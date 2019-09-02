package top.hengshare.interview.thread.concurrency;

/**
 * @author: Yang Jiaheng
 * @date: 2019/4/14
 * @description: 数字生成器
 * 这是一个抽象类，可以在需要生成数字的时候去继承该类
 */
public abstract class IntGenerator {
    /**
     * 标志位，用来标识是否取消的
     */
    private volatile boolean canceled = false;

    /**
     * 抽象方法，用来生成下一个数字
     *
     * @return
     */
    public abstract int next();

    /**
     * 设置标志位，取消生成的标志位
     */
    public void cancel() {
        canceled = true;
    }

    /**
     * 取得内部的取消标志位
     *
     * @return
     */
    public boolean isCanceled() {
        return canceled;
    }
}
