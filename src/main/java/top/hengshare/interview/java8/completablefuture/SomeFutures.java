package top.hengshare.interview.java8.completablefuture;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * for循环处理一些可以异步的任务
 *
 * @author yangjh
 */
public class SomeFutures {

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		List<CompletableFuture<String>> futures = Lists.newArrayList();
		List<String> result = Lists.newArrayList();

		for (int i = 0; i < 10; i++) {
			futures.add(CompletableFuture.supplyAsync(SomeFutures::doSome));
		}

		CompletableFuture<Void> allFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
				.whenComplete((v, t) -> futures.forEach(future -> result.add(future.getNow(null))));

		allFuture.get();

		System.out.println(result);
	}

	public static String doSome() {
		return "task" + Thread.currentThread().getId();
	}
}
