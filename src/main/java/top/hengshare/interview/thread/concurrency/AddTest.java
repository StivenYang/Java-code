package top.hengshare.interview.thread.concurrency;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author StivenYang
 * @program interview
 * @description 多线程访问共享变量冲突问题测试
 * @date 2019-07-05 09:44
 **/
public class AddTest implements Runnable {
    private static int i = 0;
    Lock lock = new ReentrantLock(false);

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AddTest test = new AddTest();
        for (int i = 0; i < 100; i++) {
            exec.execute(test);
        }
        exec.shutdown();
    }

    @Override
    public void run() {
        lock.lock();
        i++;
        Thread.yield();
        System.out.println(i);
        lock.unlock();
    }


}
