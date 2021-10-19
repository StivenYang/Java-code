package top.hengshare.interview.thread.concurrency;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/21
 * @description: 具有返回值的任务对象
 */
public class CallableDemo {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = Lists.newArrayList();
		for (int i = 0; i < 10; i++) {
			results.add(exec.submit(new TaskWithResult(i)));
		}
		for (Future<String> result : results) {
			try {
				System.out.println(result.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				exec.shutdown();
			}
		}
	}
}
