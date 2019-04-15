package top.hengshare.interviewer.thread.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author: Yang Jiaheng
 * @date: 2019/4/14
 * @description:
 */
public class EvenGenerator extends IntGenerator {
    private int currentEventValue = 0;

    @Override
    public int next() {
        ++currentEventValue;
        Thread.yield();
        ++currentEventValue;
        return currentEventValue;
    }

    public static void main(String[] args) throws InterruptedException {
        EvenChecker.test(new EvenGenerator());
    }
}
