package top.hengshare.interviewer.thread.concurrency;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/31
 * @description: 使用一个匿名内部类来实现线程
 */
public class AnonymousThread {
    private int countDown = 5;
    private Thread t;

    public AnonymousThread(String name) {
        t = new Thread(name) {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public String toString() {
                return "线程对象" + getName() + "第" + countDown + "次运行。";
            }
        };
        t.start();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new AnonymousThread(String.valueOf(i));
        }
    }
}
