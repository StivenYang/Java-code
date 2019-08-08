package top.hengshare.interviewer.thread.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/30
 * @description: 线程的Daemon属性
 */
public class ADaemon implements Runnable {
    @Override
    public void run() {
        System.out.println("开始ADaemon");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally语句被执行了");
        }
    }
}

class DaemonDontRunFinally {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ADaemon());
        //如果是后台线程，finally语句不会被执行
        //如果是前台线程，finally语句会被执行
        t.setDaemon(true);
        TimeUnit.SECONDS.sleep(2);
        t.start();
    }
}
