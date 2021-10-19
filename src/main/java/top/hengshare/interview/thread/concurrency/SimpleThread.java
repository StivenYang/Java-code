package top.hengshare.interview.thread.concurrency;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/30
 * @description: 这是第二种实现线程的方法
 * 实现一个线程，除了实现Runnable接口，使用Thread开始线程之外，
 * 还可以通过继承Thread类实现run方法，调用start方法来实现一个任务并开始一个线程
 * <p>
 * 还有一个知识点是：可以调用适当的Thread构造器为Thread对象赋予具体的名字，而这个
 * 名字可以通过调用toString方法来获取，可以用来标识一个Thread对象
 */
public class SimpleThread extends Thread {
	private int countDown = 5;
	private static int threadCount = 0;

	public SimpleThread() {
		super(Integer.toString(++threadCount));
		start();
	}

	@Override
	public String toString() {
		return "这是第" + getName() + "组，第" + countDown + "个线程.";
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(this);
			if (--countDown == 0)
				return;
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new SimpleThread();
		}
	}
}
