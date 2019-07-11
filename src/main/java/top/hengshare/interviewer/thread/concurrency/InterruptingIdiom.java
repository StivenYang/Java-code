package top.hengshare.interviewer.thread.concurrency;

/**
 * @author StivenYang
 * @program interview
 * @description 处理不同的中断异常（检查中断）
 * @date 2019-07-02 11:22
 **/
public class InterruptingIdiom {
}

/**
 *
 */
class NeedsCleanup {
    private final int id;

    public NeedsCleanup(int id) {
        this.id = id;
        System.out.println("NeedsCleanup:" + id);
    }

    public void cleanup() {
        System.out.println("Cleaning up :" + id);
    }
}

class Blocked3 implements Runnable {

    @Override
    public void run() {
        
    }
}
