package top.hengshare.interview.thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/21
 * @description: 休眠任务
 */
public class SleepingTask extends LiffOff {

	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.println(status());
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			exec.execute(new SleepingTask());
		}
		exec.shutdown();
	}
}
