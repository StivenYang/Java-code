package top.hengshare.interview.thread.concurrency;

import java.util.concurrent.ThreadFactory;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/26
 * @description: 后台线程工厂
 */
public class DaemonThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
