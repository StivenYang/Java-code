package top.hengshare.interviewer.thread.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author StivenYang
 * @program interview
 * @description 可重入锁应用
 * @date 2019-07-02 08:49
 **/
public class Interrupting2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("正在处理t.interrupt()");
        t.interrupt();
    }
}

class BlockedMutex{
    private Lock lock = new ReentrantLock();

    public BlockedMutex() {
        lock.lock();
    }

    public void f(){
        try {
            lock.lockInterruptibly();
            System.out.println("f()任务打断完毕，没有抛出异常");
        } catch (InterruptedException e) {
            System.out.println("lock在函数f()中被打断，并抛出了异常");
        }
    }
}

class Blocked2 implements Runnable{
    BlockedMutex lock = new BlockedMutex();

    @Override
    public void run() {
        System.out.println("等待调用BlockedMutex中的f()函数");
        lock.f();
        System.out.println("BlockedMutex的f()函数调用完成");
    }
}
