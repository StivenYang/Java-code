package top.hengshare.interviewer.thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author StivenYang
 * @program interview
 * @description 多线程访问共享变量冲突问题测试
 * @date 2019-07-05 09:44
 **/
public class AddTest implements Runnable {
    private static int i = 0;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AddTest test = new AddTest();
        for (int i = 0; i < 10; i++) {
            exec.execute(test);
        }
        exec.shutdown();
    }


    @Override
    public void run() {
        i++;
        Thread.yield();
        System.out.println(i);
    }
}
