package top.hengshare.interviewer.thread.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/23
 * @description: 简单后台线程启动
 */
public class SimpleDeamons implements Runnable {
    public void run() {
        try {
            while (true) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println(Thread.currentThread() + ": " + this);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<10; i++) {
            Thread t = new Thread(new SimpleDeamons());
            t.setDaemon(true);
            t.start();
        }
        System.out.println("所有的后台线程都已启动");
        TimeUnit.MILLISECONDS.sleep(2000);
    }
}
