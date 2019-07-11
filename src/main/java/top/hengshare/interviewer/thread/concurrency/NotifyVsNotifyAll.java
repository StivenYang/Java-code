package top.hengshare.interviewer.thread.concurrency;

import jdk.nashorn.internal.ir.Block;
import top.hengshare.interviewer.thread.concurrency.ThreadPoolDemo.Task;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author StivenYang
 * @program interview
 * @description Notify和NotifyAll对比
 * @date 2019-07-07 14:27
 **/
public class NotifyVsNotifyAll {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0; i<5; i++) {
            exec.execute(new Task1());
        }
        exec.execute(new Task2());
        Timer timer = new Timer();
        //使用timer运行匿名任务，每.4秒执行一次
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;

            @Override
            public void run() {
                if (prod) {
                    System.out.println("\nnotify");
                    Task1.blocker.prod();
                    prod = false;
                }else{
                    System.out.println("\nnotifyAll");
                    Task1.blocker.prodAll();
                    prod = true;
                }
            }
        }, 400, 400);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("定时器取消了");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("task2.blocker.prodAll()");
        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("shutting down");
        exec.shutdownNow();
    }
}

class Blocker {
    synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.println("线程：" + Thread.currentThread() + "正在运行");
            }
        } catch (InterruptedException e) {
            System.out.println("正常退出这个方法");
        }
    }
    synchronized void prod(){
        notify();
    }
    synchronized void prodAll(){
        notifyAll();
    }
}

class Task1 implements Runnable {
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}

class Task2 implements Runnable {
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
