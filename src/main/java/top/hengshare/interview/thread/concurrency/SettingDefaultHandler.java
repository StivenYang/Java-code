package top.hengshare.interview.thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/31
 * @description: 设置默认的线程异常处理器
 * <p>
 * 这个处理器在不存在线程专有的未捕获异常的处理器的情况下才会被调用。
 * 检查的顺序是：1. 检查是否有专有的异常捕获处理器
 * 2. 检查是否有默认异常捕获处理器
 */
public class SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
