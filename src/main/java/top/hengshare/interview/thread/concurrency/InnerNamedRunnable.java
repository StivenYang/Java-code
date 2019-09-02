package top.hengshare.interview.thread.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/31
 * @description: 使用一个已命名的实现了Runnable接口的类来实现线程类
 */
public class InnerNamedRunnable {
    private int countDown = 5;
    private Inner inner;

    private class Inner implements Runnable {
        Thread t;

        public Inner(String name) {
            t = new Thread(this, name);
            t.start();
        }

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
            return "线程" + t.getName() + "第" + countDown + "次运行。";
        }
    }

    public InnerNamedRunnable(String name) {
        this.inner = new Inner(name);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new InnerNamedRunnable(String.valueOf(i));
        }
    }
}
