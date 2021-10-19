package top.hengshare.interview.thread.concurrency;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author StivenYang
 * @program interview
 * @description 多线程实例-装饰性花园
 * @date 2019-06-30 13:44
 **/
public class OrnamentalGarden {

	public static void main(String[] args) throws InterruptedException {
		//新建一个线程池，用来存放各个入口的任务
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			//设置五个入口
			exec.execute(new Entrance(i));
		}
		TimeUnit.SECONDS.sleep(3);
		Entrance.cancel();
		exec.shutdown();
		if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
			System.out.println("貌似一些线程没有被终止？");
		}
		System.out.println("一共有：" + Entrance.getCount() + "个人进入花园");
		System.out.println("入口一共有：" + Entrance.sumEntrances() + "个人进入");
	}
}

/**
 * 一个计数器，用来统计进入花园的人数
 * count应该有一个增加方法，还有一个取值的方法
 */
class Count {
	private int count = 0;
	private Random rand = new Random(47);

	/**
	 * 移除关键字synchronized会看到计数失败
	 */
	public synchronized int increment() {
		int temp = count;
		if (rand.nextBoolean()) {
			Thread.yield();
		}
		return (count = ++temp);
	}

	public synchronized int value() {
		return count;
	}
}

/**
 * 这个类代表花园的入口
 * 入口应该有一个计数器，来统计经过这个入口的人数
 */
class Entrance implements Runnable {

	/**
	 * 门上安装的计数器
	 */
	private static Count count = new Count();
	/**
	 * 入口
	 */
	private static List<Entrance> entrances = Lists.newArrayList();
	/**
	 * 标识当前入口当前进入人数
	 */
	private int number = 0;
	/**
	 * 入口的id
	 */
	private final int id;
	/**
	 * 停止计数标识,volatile关键字为了保证线程间可见性
	 */
	private static volatile boolean canceled = false;

	/**
	 * 给一个volatile字段包装函数
	 */
	public static void cancel() {
		canceled = true;
	}

	public Entrance(int id) {
		this.id = id;
		//把新建的任务放进列表中，防止垃圾回收器将死亡的任务回收
		entrances.add(this);
	}


	@Override
	public void run() {
		while (!canceled) {
			//当任务没有被取消的时候，每新增一个入口，我们就给number+1，
			// 为了防止同时新增入口，导致资源竞争冲突，我们加上synchronized关键字
			synchronized (this) {
				++number;
			}
			System.out.println(this + "当前一共进入：" + count.increment() + "个人");
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("sleep被打断了");
			}
		}
		System.out.println("入口" + this.id + "被关了");
	}

	/**
	 * 获取入口号
	 *
	 * @return
	 */
	public synchronized int getValue() {
		return number;
	}

	@Override
	public String toString() {
		return "入口" + id + "第" + number + "个人。";
	}

	/**
	 * 获取该入口进入总人数
	 *
	 * @return
	 */
	public static int getCount() {
		return count.value();
	}

	/**
	 * 获取花园的总入口数
	 *
	 * @return
	 */
	public static int sumEntrances() {
		int sum = 0;
		for (Entrance entrance : entrances) {
			sum += entrance.getValue();
		}
		return sum;
	}
}

