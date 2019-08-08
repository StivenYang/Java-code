package top.hengshare.interviewer.thread.concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author StivenYang
 * @program interview
 * @description 线程中断-使用excutor的shutdownnow
 * @date 2019-06-30 17:10
 * <p>
 * 主要用来测试不同类型的阻塞在遇到interrupt信号之后会产生什么样的结果（异常或者正常退出）
 * </p>
 **/
public class Interrupting {
    private static ExecutorService executors = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        Future<?> future = executors.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("正在试图中断：" + r.getClass().getName());
        //调用future的cancel会发送interrupt信号给线程
        future.cancel(true);
        System.out.println("中断信号已发送给：" + r.getClass().getName());
    }

    /**
     * 结论是：SleepBlocked是可中断的阻塞，而IOBlocked和SynchronizedBlocked是不可中断的阻塞
     * 前者中断后会抛出interrupt异常，而后面两者会直接关闭，程序不会向下继续执行
     * <p>
     * 造成的结果就是：在第一种阻塞中，我们可以进行中断，这并不会影响我们的程序；而后面两种则会对我们
     * 的程序造成影响，因为IOBlocked阻塞会在不正常退出后继续占用io设备，sychronizedBlocked不会释放
     * 对资源的加锁
     * <p>
     * 有一个略显笨拙但是却行之有效的办法：关闭任务在其上发生阻塞的底层资源 {@link CloseResource}
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocked());
        //正在试图中断：top.hengshare.interviewer.thread.concurrency.SleepBlocked
        //中断信号已发送给：top.hengshare.interviewer.thread.concurrency.SleepBlocked
        //SleepBlocked线程被中断
        //SleepBlocked正常退出
        test(new IOBlocked(System.in));
        //等待从缓冲区读取数据：
        //正在试图中断：top.hengshare.interviewer.thread.concurrency.IOBlocked
        //中断信号已发送给：top.hengshare.interviewer.thread.concurrency.IOBlocked
        test(new SynchronizedBlocked());
        //尝试调用已经被加锁的fn函数
        //正在试图中断：top.hengshare.interviewer.thread.concurrency.SynchronizedBlocked
        //中断信号已发送给：top.hengshare.interviewer.thread.concurrency.SynchronizedBlocked
        TimeUnit.SECONDS.sleep(3);
        System.out.println("正常退出，返回值为exit(0)");
        System.exit(0);
    }
}

/**
 * 调用sleep方法被阻塞
 */
class SleepBlocked implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("SleepBlocked线程被中断");
        }
        System.out.println("SleepBlocked正常退出");
    }
}

/**
 * 正在调用设备的io时被阻塞
 */
class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream is) {
        this.in = is;
    }

    @Override
    public void run() {
        try {
            System.out.println("等待从缓冲区读取数据：");
            in.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("中断发生在IOBlocked中");
            } else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("IOBlocked正常退出");
    }
}

/**
 * 在等待被占用资源释放时线程被阻塞
 */
class SynchronizedBlocked implements Runnable {

    public synchronized void f() {
        while (true) {
            Thread.yield();
        }
    }

    /**
     * 在初始化的时候对该对象进行加锁
     */
    public SynchronizedBlocked() {
        new Thread() {
            @Override
            public void run() {
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("尝试调用已经被加锁的fn函数");
        f();
        System.out.println("synchronizedBlocked正常退出");
    }
}
