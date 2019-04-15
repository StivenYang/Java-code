package top.hengshare.interviewer.thread.concurrency;

/**
 * @author: Yang Jiaheng
 * @date: 2019/4/14
 * @description: 同步的事件生成器
 *
 * 同步以后的方法每次都会+1+1，所以会一直执行下去，满足我们的预期
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
