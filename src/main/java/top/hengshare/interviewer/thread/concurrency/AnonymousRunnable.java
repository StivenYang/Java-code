package top.hengshare.interviewer.thread.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/31
 * @description:
 */
public class AnonymousRunnable {
    private int countDown = 5;
    private Thread t;
    public AnonymousRunnable(String name) {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public String toString() {
                return "线程" + Thread.currentThread().getName() + "第" + countDown + "次运行";
            }
        }, name);
        t.start();
    }

    public static void main(String[] args) {
        for (int i=0; i<5; i++) {
            new AnonymousRunnable(String.valueOf(i));
        }
    }
}
