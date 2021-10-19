package top.hengshare.interview.thread.concurrency.ThreadPoolDemo;

/**
 * 循环打印
 *
 * @author yjh
 * @since 2020/11/25
 */
public class 循环打印 {

}

class 线程A extends Thread {

	private 测试线程 测试线程实例;

	public 线程A(测试线程 测试线程实例) {
		this.测试线程实例 = 测试线程实例;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			测试线程实例.打印字符串(i, "A");
		}
		System.out.println("线程A打印完了");
	}
}

class 线程B extends Thread {
	private 测试线程 测试线程实例;

	public 线程B(测试线程 测试线程实例) {
		this.测试线程实例 = 测试线程实例;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			测试线程实例.打印字符串(i, "B");
		}
		System.out.println("线程B打印完了");
	}
}

class 测试线程 {

	public synchronized void 打印字符串(int count, String str) {
		String name = Thread.currentThread().getName();
		if ("A".equals(str)) {
			System.out.println(name + "-----" + str);
		} else if ("B".equals(str)) {
			System.out.println(name + "-----" + str);
		}
		try {
			notify();
			if (count != 4) {
				wait();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		测试线程 测试线程实例 = new 测试线程();
		线程A 线程A实例 = new 线程A(测试线程实例);
		线程B 线程B实例 = new 线程B(测试线程实例);
		线程A实例.setName("线程A：");
		线程B实例.setName("线程B：");
		线程B实例.setPriority(2);
		线程B实例.start();
		线程A实例.start();
		try {
			线程A实例.join();
			线程B实例.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("全部都打印完了");
	}
}
