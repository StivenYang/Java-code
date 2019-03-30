package top.hengshare.interviewer.thread.concurrency;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/30
 * @description:
 */
public class SelfManaged implements Runnable {
    private int countDown = 10;
    private Thread t = new Thread(this);
    public SelfManaged(){
        t.start();
    }

    @Override
    public String toString() {
        return "当前是" + Thread.currentThread().getName() + "对象的第" + countDown + "个线程。";
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i= 0; i< 10; i++) {
            new SelfManaged();
        }
    }
}
