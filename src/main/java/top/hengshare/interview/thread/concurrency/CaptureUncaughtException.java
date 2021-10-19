package top.hengshare.interview.thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/31
 * @description:
 */
class ExceptionThread2 implements Runnable {

	@Override
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("线程" + t + "运行");
		System.out.println("线程的异常处理器是eh=" + t.getUncaughtExceptionHandler());
		throw new RuntimeException();
	}
}

class MyUnCaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("捕获到了异常：" + e);
	}
}

class HandlerThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		System.out.println("工厂" + this + "正在创建新的线程");
		Thread t = new Thread(r);
		System.out.println("创建的线程是" + t);
		t.setUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
		System.out.println("线程的异常处理器是：" + t.getUncaughtExceptionHandler());
		return t;
	}
}

public class CaptureUncaughtException {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
		exec.execute(new ExceptionThread2());
	}
}
