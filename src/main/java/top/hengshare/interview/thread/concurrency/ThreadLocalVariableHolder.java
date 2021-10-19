package top.hengshare.interview.thread.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author StivenYang
 * @program interview
 * @description 线程本地存储
 * @date 2019-04-27 19:21
 **/
public class ThreadLocalVariableHolder {
	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
		private Random rand = new Random(47);

		@Override
		protected synchronized Integer initialValue() {
			return rand.nextInt(10000);
		}
	};

	public static int get() {
		return value.get();
	}

	public static void increment() {
		value.set(value.get() + 1);
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new Accessor(i));
		}
		TimeUnit.SECONDS.sleep(3);
		exec.shutdown();
	}
}

class Accessor implements Runnable {
	private final int id;

	public Accessor(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			ThreadLocalVariableHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}

	@Override
	public String toString() {
		return "线程：" + id + ":" + ThreadLocalVariableHolder.get();
	}
}
