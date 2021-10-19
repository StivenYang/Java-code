package top.hengshare.interview.thread.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/30
 * @description: 后台线程产生的新的线程都是后台线程
 */
public class Deamons implements Runnable {
	private Thread[] t = new Thread[10];

	@Override
	public void run() {
		for (int i = 0; i < t.length; i++) {
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println("DaemonSpawn " + i + " started.");
		}
		for (int i = 0; i < t.length; i++) {
			System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ".");
		}
		while (true) {
			Thread.yield();
		}
	}
}

class DaemonSpawn implements Runnable {

	@Override
	public void run() {
		while (true) {
			Thread.yield();
		}
	}
}

class Daemon {
	public static void main(String[] args) throws InterruptedException {
		Thread d = new Thread(new Deamons());
		d.setDaemon(true);
		d.start();
		System.out.println("d.isDaemon() = " + d.isDaemon() + ".");
		TimeUnit.SECONDS.sleep(5);
	}
}