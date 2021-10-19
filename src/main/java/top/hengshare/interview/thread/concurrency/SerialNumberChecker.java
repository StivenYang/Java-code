package top.hengshare.interview.thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author StivenYang
 * @program interview
 * @description SerialNumber生成器检查, 用来测试sychronized作用在一个方法上的作用
 * @date 2019-04-27 16:16
 **/
public class SerialNumberChecker {
	private static final int SIZE = 10;
	private static CircularSet circularSet = new CircularSet(1000);
	private static ExecutorService exec = Executors.newCachedThreadPool();

	static class SerialChecker implements Runnable {

		@Override
		public void run() {
			while (true) {
				int serialNumber = SeriaNumberGenerator.nextSerialNumber();
				if (circularSet.contains(serialNumber)) {
					System.out.println("重复的值：" + serialNumber);
					System.exit(0);
				}
				circularSet.add(serialNumber);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < SIZE; i++) {
			exec.execute(new SerialChecker());
			//等待n秒
			if (args.length > 0) {
				TimeUnit.SECONDS.sleep(new Integer(args[0]));
				System.out.println("没有检测到重复值");
				System.exit(0);
			}
		}
	}
}

class CircularSet {
	private int[] array;
	private int index = 0;
	private int len;

	public CircularSet(int size) {
		array = new int[size];
		len = size;
		for (int i = 0; i < size; i++) {
			array[i] = -1;
		}
	}

	public synchronized void add(int i) {
		array[index] = i;
		index = ++index % len;
	}

	public synchronized boolean contains(int val) {
		for (int i = 0; i < len; i++) {
			if (array[i] == val) {
				return true;
			}
		}
		return false;
	}
}
