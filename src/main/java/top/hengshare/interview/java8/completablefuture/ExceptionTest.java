package top.hengshare.interview.java8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 测试异常任务编排
 *
 * @author yangjh
 */
public class ExceptionTest {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(3000);
				return 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
				return 4;
			}
		});
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 2);
		future2.thenAcceptBoth(future1, (r1, r2) -> System.out.println(r1 + "-" + r2)).get();

		CompletableFuture<String> future11 = CompletableFuture.supplyAsync(() -> "zhangphil");
		CompletableFuture<Integer> future12 = CompletableFuture.supplyAsync(() -> 2018);
		future12.thenAcceptBothAsync(future11, (integer, s) -> System.out.println(integer + " , " + s));
	}
}
