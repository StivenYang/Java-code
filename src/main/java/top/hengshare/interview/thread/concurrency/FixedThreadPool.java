package top.hengshare.interview.thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/21
 * @description: 固定线程池，在特定情况下使用
 */
public class FixedThreadPool {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiffOff());
		}
		exec.shutdown();
	}
}
