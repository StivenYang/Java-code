package top.hengshare.interviewer.thread.concurrency;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.w3c.dom.css.Counter;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author StivenYang
 * @program interview
 * @description CountDownLatch示例
 * @date 2019-07-10 15:02
 **/
class TaskPortion implements Runnable {
    //计数器
    private static int counter = 0;
    //标识
    private final int id = counter++;
    //随机数种子
    private static Random random = new Random(47);
    //countDownLatch
    private final CountDownLatch latch;
    //构造函数
    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            dowork();
            latch.countDown();
        } catch (InterruptedException e) {
        }
    }

    public void dowork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
        System.out.println(this + "完成");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d ", id);
    }
}

class WaitingTask implements Runnable {
    //计数器
    private static int counter = 0;
    //标识符
    private final int id = counter++;
    //CountDownLatch
    private final CountDownLatch latch;
    //构造函数
    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("latch完成，其余等待任务开始执行" + this);
        } catch (InterruptedException e) {
            System.out.println(this + "被中断");
        }
    }

    @Override
    public String toString() {
        return String.format("等候任务 %1$-3d", id);
    }
}

public class CountDownLatchDemo {
    //countdownlatch的大小
    static final int SIZE = 100;
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);
        //所有的CountDownLatch对象共享一个CountDownLatch
        for (int i=0; i<10; i++) {
            exec.execute(new WaitingTask(latch));
        }
        for (int i=0; i<SIZE; i++) {
            exec.execute(new TaskPortion(latch));
        }
        //运行两种任务
        System.out.println("两种任务均运行完毕");
        //打印提示信息
        exec.shutdown();
        //关闭线程池
    }
}
