package top.hengshare.interview.thread.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: Java-Interview
 * @description: CAS
 * @author: StivenYang
 * @create: 2019-11-25 00:09
 **/
public class CAS {
    /**
     *
     */
    private static final CountDownLatch latch = new CountDownLatch(5);
    /**
     * 在内存中分配一个Integer对象
     */
    private static AtomicInteger i = new AtomicInteger(0);
    private static int p = 0;


}
