package top.hengshare.interview.thread.concurrency;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/20
 * @description: 简单的调用任务对象的方法，并不是线程
 */
public class MainThread {
	public static void main(String[] args) {
		LiffOff liffOff = new LiffOff();
		liffOff.run();
	}
}
