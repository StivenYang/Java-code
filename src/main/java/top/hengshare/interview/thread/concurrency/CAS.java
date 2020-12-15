package top.hengshare.interview.thread.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: Java-Interview
 * @description: CAS
 * @author: StivenYang
 * @create: 2019-11-25 00:09
 **/
public class CAS {
    /**
     * 固定边界的线程执行器
     */
    private static final CountDownLatch latch = new CountDownLatch(5);
    /**
     * 在内存中分配一个Integer对象
     */
    private static AtomicInteger i = new AtomicInteger(0);
    /**
     * 操作数据
     */
    private static int p = 0;

    public static void main(String[] args) throws InterruptedException {
        long time = System.currentTimeMillis();
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int j=0; j<5; j++){
            exec.execute(() -> {
                for (int k=0; k<1000; k++){
                    p++;    //不是原子操作
                    i.getAndIncrement();    //调用原子类加1
                }
                latch.countDown();
            });
        }
        latch.await();//保证所有子线程完成
        System.out.println(System.currentTimeMillis()-time);
        System.out.println("p=" + p);
        System.out.println("i=" + i);
        exec.shutdown();
    }
}
