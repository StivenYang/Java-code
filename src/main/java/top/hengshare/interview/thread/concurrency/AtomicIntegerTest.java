package top.hengshare.interview.thread.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author StivenYang
 * @program interview
 * @description 使用AtomicInteger解决当对象处于不稳定状态时并发产生的错误问题
 * @date 2019-04-27 16:59
 **/
public class AtomicIntegerTest implements Runnable {
	private AtomicInteger i = new AtomicInteger(0);

	public int getValue() {
		return i.get();
	}

	@Override
	public void run() {
		while (true) {
			evenIncrement();
		}
	}

	private void evenIncrement() {
		i.addAndGet(2);
	}

	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("打断中");
				System.exit(0);
			}
		}, 5000); //只让终端无响应5s，之后自动退出
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicIntegerTest ait = new AtomicIntegerTest();
		exec.execute(ait);
		while (true) {
			int val = ait.getValue();
			if (val % 2 != 0) {
				System.out.println(val);
				System.exit(0);
			}
		}
	}
}
