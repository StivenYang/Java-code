package top.hengshare.interviewer.thread.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author StivenYang
 * @program interview
 * @description 稳定的、线程安全的数字生成器
 * @date 2019-04-27 17:09
 **/
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger ai = new AtomicInteger(0);

    @Override
    public int next() {
        return ai.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
