package top.hengshare.interview.thread.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @author StivenYang
 * @program interview
 * @description 吐司的协作生产-使用队列
 * @date 2019-07-09 19:13
 **/
public class Toast0Matic {
	public static void main(String[] args) throws InterruptedException {
		//新建三个队列，用来放加工的吐司
		ToastQueue dryQueue = new ToastQueue(), butteredQueue = new ToastQueue(), jammedQueue = new ToastQueue();
		ExecutorService exec = Executors.newCachedThreadPool();
		//对队列中的吐司进行相应的加工
		exec.execute(new Toaster(dryQueue));
		exec.execute(new Butterer(dryQueue, butteredQueue));
		exec.execute(new Jammer(butteredQueue, jammedQueue));
		exec.execute(new Eater(jammedQueue));
		//加工几秒钟
		TimeUnit.SECONDS.sleep(5);
		//关机
		exec.shutdownNow();
	}
}

class Toast {
	/**
	 * 制作状态：制作、抹油、涂果酱
	 */
	public enum Status {
		/**
		 * 吐司制作
		 */
		DRY,
		/**
		 * 给吐司抹黄油
		 */
		BUTTERED,
		/**
		 * 吐司涂果酱
		 */
		JAMMED
	}

	//当前状态
	private Status status = Status.DRY;
	//标识id
	private final int id;

	//构造函数
	public Toast(int idn) {
		this.id = idn;
	}

	//摸黄油
	public void butter() {
		status = Status.BUTTERED;
	}

	//涂果酱
	public void jam() {
		status = Status.JAMMED;
	}

	//获取当前状态
	public Status getStatus() {
		return this.status;
	}

	//获取标识
	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "吐司{" + "当前工序{" + status + ", 当前id=" + id + '}';
	}
}

/**
 * 吐司队列
 */
class ToastQueue extends LinkedBlockingDeque<Toast> {

}

/**
 * 吐司机-制作吐司（消费者）
 */
class Toaster implements Runnable {
	//吐司队列
	private ToastQueue toastQueue;
	//计数器
	private int count = 0;
	//随机数
	private Random rand = new Random(47);

	//构造函数
	public Toaster(ToastQueue queue) {
		this.toastQueue = queue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
				Toast toast = new Toast(count++);
				System.out.println(toast);
				toastQueue.put(toast);
			}
		} catch (InterruptedException e) {
			System.out.println("吐司制作机发生异常");
		}
		System.out.println("吐司制作完毕");
	}
}

/**
 * 抹黄油机-（消费者）
 */
class Butterer implements Runnable {
	//吐司制作队列,抹黄油吐司队列
	private ToastQueue dryQueue, butterQueue;

	//构造函数
	public Butterer(ToastQueue dryQueue, ToastQueue butterQueue) {
		this.dryQueue = dryQueue;
		this.butterQueue = butterQueue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast take = dryQueue.take();
				take.butter();
				System.out.println(take);
				butterQueue.put(take);
			}
		} catch (InterruptedException e) {
			System.out.println("黄油机出现异常");
		}
		System.out.println("黄油涂抹完毕");
	}
}

/**
 * 涂果酱机-（消费者）
 */
class Jammer implements Runnable {
	//吐司制作队列、摸黄油队列、涂果酱队列
	ToastQueue butterQueue, jammedQueue;

	//构造函数
	public Jammer(ToastQueue butterQueue, ToastQueue jammedQueue) {
		this.butterQueue = butterQueue;
		this.jammedQueue = jammedQueue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast take = butterQueue.take();
				take.jam();
				jammedQueue.put(take);
				System.out.println(take);
			}
		} catch (InterruptedException e) {
			System.out.println("果酱机出现异常");
		}
		System.out.println("果酱涂抹完毕");
	}
}

/**
 * 顾客-消费者-对队列中加工完成的吐司消费
 */
class Eater implements Runnable {
	//吐司队列
	private ToastQueue finishQueue;

	//计数器
	private int counter = 0;

	//构造器
	public Eater(ToastQueue queue) {
		this.finishQueue = queue;
	}

	@Override
	public void run() {
		try {
			//消费加工完成的吐司
			Toast take = finishQueue.take();
			if (take.getId() != counter++ || take.getStatus() != Toast.Status.JAMMED) {
				System.out.println(take + "该吐司还没加工完，无法食用");
			} else {
				System.out.println(take + "被吃掉了！");
			}
		} catch (InterruptedException e) {
			System.out.println("吃的时候发生了异常");
		}
		System.out.println("吃完了");
	}
}
