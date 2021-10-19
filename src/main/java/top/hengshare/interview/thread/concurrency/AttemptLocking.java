package top.hengshare.interview.thread.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: Yang Jiaheng
 * @date: 2019/4/14
 * @description: Lock加锁 - 定制
 * <p>
 * 该类会演示对资源加锁一段时间，然后释放锁的情况
 */
public class AttemptLocking {
	private ReentrantLock lock = new ReentrantLock();

	public void unTimed() {
		boolean captured = lock.tryLock();
		try {
			System.out.println("尝试加锁" + captured);
		} finally {
			lock.unlock();
		}
	}

	public void timed() {
		boolean captured = false;
		try {
			captured = lock.tryLock(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("尝试加锁两秒钟" + captured);
		} finally {
			if (captured) {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		final AttemptLocking al = new AttemptLocking();
		al.unTimed();
		al.timed();
		new Thread() {
			{
				setDaemon(true);
			}

			public void run() {
				al.lock.lock();
				System.out.println("拿到锁");
			}
		}.start();
		Thread.yield();
		Thread.yield();
		al.unTimed();
		al.timed();
	}
}
