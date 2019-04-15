package top.hengshare.interviewer.thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Yang Jiaheng
 * @date: 2019/4/14
 * @description:
 */
public class AtomicityTest implements Runnable {
    private int i = 0;
    public int getValue(){
        return i;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int value = at.getValue();
            if (value % 2 != 0) {
                System.out.println(value);
                System.exit(0);
            }
        }
    }
}
