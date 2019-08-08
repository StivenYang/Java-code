package top.hengshare.interviewer.thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/20
 * @description: 缓存线程池
 * 一般情况下均使用该线程池，特定情况下使用其他线程池
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiffOff());
        }
        exec.shutdown();
    }
}
