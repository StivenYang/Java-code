package top.hengshare.interview.java8.completablefuture;

import java.util.concurrent.*;

/**
 * Java8之前使用JDK1.5的future方法
 */
public class FutureTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Double> future = executorService.submit(FutureTest::doSomeLongComputation);
        //异步操作进行的同时，可以做其他的事情
        doSomethingElse();
        //获取异步操作的结果，如果最终被阻塞， 无法得到结果， 那么在最多等待1秒钟之后退出
        try {
            Double result = future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    /**
     * 做一些其他的事情
     */
    private static void doSomethingElse() {
    }

    /**
     * 做一些很长时间的计算
     * @return 返回计算的结果
     */
    private static Double doSomeLongComputation() {
        return null;
    }


}
