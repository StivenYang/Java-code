package top.hengshare.interview.thread.concurrency;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/31
 * @description: 使用命名内部类来实现线程
 */
public class InnerNamedThread {
	private int countDown = 5;
	private Inner inner;

	private class Inner extends Thread {
		Inner(String name) {
			super(name);
			start();
		}

		@Override
		public void run() {
			try {
				while (true) {
					System.out.println(this);
					if (--countDown == 0) {
						return;
					}
					sleep(10);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Override
		public String toString() {
			return "线程对象" + getName() + "第" + countDown + "次运行.";
		}
	}

	public InnerNamedThread(String name) {
		inner = new Inner(name);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new InnerNamedThread("线程" + i);
		}
	}
}
