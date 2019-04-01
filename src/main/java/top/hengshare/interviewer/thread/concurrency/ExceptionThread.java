package top.hengshare.interviewer.thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/31
 * @description: 线程的异常捕获
 *
 * 要点1. 使用try...catch并不能捕获到线程中的异常
 */
public class ExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
//        Thread thread = new Thread(new ExceptionThread());
        //使用这个方法并不能捕获到线程中抛出的异常
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
