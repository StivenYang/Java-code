package top.hengshare.interviewer.thread.concurrency;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/20
 * @description: 使用线程来执行任务
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            new Thread(new LiffOff()).start();
        }
        System.out.println("发射完毕！");
    }
}
