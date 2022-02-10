package top.hengshare.interview.id;

import cn.hutool.core.date.SystemClock;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.lang.management.ManagementFactory;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 分布式高效有序ID生产黑科技(sequence)
 * <p>优化开源项目：https://gitee.com/yu120/sequence</p>
 *
 * @author hubin
 * @since 2016-08-18
 */
@Slf4j
public class Sequence {

	private static final long MAX_OFFSET = 5L ;
	/**
	 * 时间起始标记点，作为基准，一般取系统的最近时间（一旦确定不能变动）
	 */
	private static final long TWEPOCH = 1288834974657L;
	/**
	 * 机器标识位数
	 */
	private static final long WORKER_ID_BITS = 11L;

	private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);

	/**
	 * 毫秒内自增位
	 */
	private static final long SEQUENCE_BITS = 11L;

	private static final long WORKER_ID_SHIFT = 11L;
	/**
	 * 时间戳左移动位 12+5+5
	 */
	private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;

	/**
	 *	毫秒内最大生成数量 1<<11 2048
	 */
	private static final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);

	private   long workerId;

	/**
	 * 并发控制
	 */
	private long sequenceNums = 0L;
	/**
	 * 上次生产 ID 时间戳
	 */
	private long lastTimestamp = -1L;



	/**
	 * 有参构造器
	 *
	 * @param workerId     工作机器 ID
	 */
	public Sequence(long workerId) {
		Assert.isTrue(workerId < MAX_WORKER_ID && workerId > 0,
				String.format("worker Id can't be greater than %d or less than 0", MAX_WORKER_ID));
		this.workerId = workerId;
	}

	public Sequence(){
		this.workerId= getLocalWorkerId(MAX_WORKER_ID);
	}

	/**
	 * 通过pid计算出一个workerId
	 * @param maxWorkerId   maxWorkerId
	 */
	protected static long getLocalWorkerId(long maxWorkerId) {
		StringBuilder mpid = new StringBuilder();
		String name = ManagementFactory.getRuntimeMXBean().getName();
		if (StringUtils.isNotBlank(name)) {
			/*
			 * GET jvmPid
			 */
			mpid.append(name.split("@")[0]);
		}
		/*
		 * MAC + PID 的 hashcode 获取16个低位
		 */
		return (mpid.toString().hashCode() & 0xffff) % (maxWorkerId + 1);
	}



	/**
	 * 获取下一个 ID
	 *
	 * @return 下一个 ID
	 */
	public synchronized long nextId() {
		long timestamp = timeGen();
		//闰秒
		if (timestamp < lastTimestamp) {
			long offset = lastTimestamp - timestamp;
			if (offset <= MAX_OFFSET) {
				try {
					wait(offset << 1); //NOSONAR
					timestamp = timeGen();
					if (timestamp < lastTimestamp) {
						throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", offset)); //NOSONAR
					}
				} catch (Exception e) {
					throw new RuntimeException(e); //NOSONAR
				}
			} else {
				throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", offset)); //NOSONAR
			}
		}

		if (lastTimestamp == timestamp) {
			// 相同毫秒内，序列号自增
			sequenceNums = (sequenceNums + 1) & SEQUENCE_MASK;
			if (sequenceNums == 0) {
				// 同一毫秒的序列数已经达到最大
				timestamp = tilNextMillis(lastTimestamp);
			}
		} else {
			// 不同毫秒内，序列号置为 1 - 3 随机数
			sequenceNums = ThreadLocalRandom.current().nextLong(1, 3);
		}

		lastTimestamp = timestamp;

		// 时间戳部分 | 数据中心部分 | 机器标识部分 | 序列号部分
		return ((timestamp - TWEPOCH) << TIMESTAMP_LEFT_SHIFT)
				| (workerId << WORKER_ID_SHIFT)
				| sequenceNums;
	}

	protected long tilNextMillis(long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	protected long timeGen() {
		return SystemClock.now();
	}

	public void setWorkerId(long workerId) {
		this.workerId = workerId;
	}

}