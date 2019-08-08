package top.hengshare.interviewer.thread.concurrency;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/20
 * @description: 一个简单的任务对象
 */
public class LiffOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiffOff() {
    }

    public LiffOff(int countDown) {
        this.countDown = countDown;
    }

    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }

    protected String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiffOff!") + ")";
    }
}
