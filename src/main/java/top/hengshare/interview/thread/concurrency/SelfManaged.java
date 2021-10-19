package top.hengshare.interview.thread.concurrency;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/30
 * @description: 这是一个自管理的线程对象，他的优点是可以不用继承Thread类来实现一个线程对象
 * <p>
 * 在自管理的线程对象里面需要有一个Thread对象来start线程，还需要实现Runnable接口的run方法
 * 然后在自管理线程对象的构造方法中调用start来实现一个线程
 * <p>
 * 在构造器里面启动一个线程是有问题的：因为另一个任务可能会在构造器结束之前开始执行，这意味着该任务
 * 能够访问处于不稳定状态的对象。
 * 这是优选Executor启动线程而不是显式的创建Thread对象的另外一个原因。
 */
public class SelfManaged implements Runnable {
	private int countDown = 10;
	private Thread t = new Thread(this);

	public SelfManaged() {
		t.start();
	}

	@Override
	public String toString() {
		return "当前是" + Thread.currentThread().getName() + "对象的第" + countDown + "个线程。";
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(this);
			if (--countDown == 0) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new SelfManaged();
		}
	}
}
