package top.hengshare.interview.thread.concurrency;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/20
 * @description: 使用Thread执行任务，产生线程
 */
public class BasicThreads {
	public static void main(String[] args) {
		Thread thread = new Thread(new LiffOff());
		thread.start();
		System.out.println("等待发射");
	}
}
