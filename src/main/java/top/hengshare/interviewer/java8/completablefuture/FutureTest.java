package top.hengshare.interviewer.java8.completablefuture;

import java.util.concurrent.*;

public class FutureTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Double> future = executorService.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
//                return doSomeLongComputation();
                return null;
            }
        });
        //异步操作进行的同时，可以做其他的事情
//        doSomethingElse();
        //获取异步操作的结果，如果最终被阻塞， 无法得到结果， 那么在最多等待1秒钟之后退出
        try {
            Double result = future.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
