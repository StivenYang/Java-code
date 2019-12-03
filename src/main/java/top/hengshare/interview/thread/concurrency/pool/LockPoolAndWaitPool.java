package top.hengshare.interview.thread.concurrency.pool;

/**
 * @program: Java-Interview
 * @description: 对象的锁池和等待池的概念
 * @author: StivenYang
 * @create: 2019-11-27 11:42
 **/
public class LockPoolAndWaitPool {
    //这里的volatile不可以省略，变量可视化
    public volatile int count;

    public static void main(String[] args) {
        // 初始化要修改的值
        LockPoolAndWaitPool target = new LockPoolAndWaitPool();

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                try {
                    Thread.sleep((long) (Math.random() * 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 这块的this和target不可以混用，否则锁池和等待池会混淆
                synchronized (target) {
                    if (target.count == 2) {
                        try {
                            target.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    target.count++;
                    System.out.println(Thread.currentThread().getName() + ": " + target.count);
                    target.notify();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                try {
                    Thread.sleep((long) (Math.random() * 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 这块的this和target不可以混用，否则锁池和等待池会混淆
                synchronized (target) {
                    if (target.count == 0) {
                        try {
                            // 等待，由于Decrease线程调用的该方法
                            target.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    target.count--;
                    System.out.println(Thread.currentThread().getName() + ": " + target.count);
                    target.notify();
                }
            }
        }).start();
    }
}
