package top.hengshare.interview.java8.completablefuture;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.concurrent.*;

public class ThreadPoolTest implements Callable {

    static ExecutorService exec = Executors.newFixedThreadPool(10, r -> {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    });

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Double d = 0D;
        long start = System.currentTimeMillis();
        ArrayList<Future> list = Lists.newArrayList();

        Future future;
        for (int i = 0; i < 10; i++) {
            future = exec.submit(new ThreadPoolTest());
            list.add(future);
        }

        for (Future future1 : list) {
            d += (Double) future1.get();
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(d);

    }


    @Override
    public Double call() throws Exception {
        Double a = 0D;
        for (int i = 100_000; i > 0; i--) {
//            System.out.println(i);
            a = a + i;
        }
        return a;
    }
}
