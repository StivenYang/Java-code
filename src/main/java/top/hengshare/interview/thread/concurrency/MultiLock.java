package top.hengshare.interview.thread.concurrency;

/**
 * @author StivenYang
 * @program interview
 * @description 同一个锁，如何被同一个任务多次获得
 * @date 2019-07-02 08:27
 **/
public class MultiLock {

	private synchronized void f1(int count) {
		if (count-- > 0) {
			System.out.println("f1()调用f2()" + count + "次");
			f2(count);
		}
	}

	private synchronized void f2(int count) {
		if (count-- > 0) {
			System.out.println("f2()调用f1()" + count + "次");
			f1(count);
		}
	}

	public static void main(String[] args) {
		/**
		 * 如果在一个对象上调用其synchronized方法，而这个对象的锁已经被其他任务获得
		 * 那么调用任务将被挂起（阻塞），直至这个锁可获得
		 */
		final MultiLock multiLock = new MultiLock();
		new Thread() {

			@Override
			public void run() {
				multiLock.f1(10);
			}
		}.start();
	}
}
