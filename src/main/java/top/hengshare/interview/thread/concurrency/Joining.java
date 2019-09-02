package top.hengshare.interview.thread.concurrency;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/31
 * @description: 理解线程的join()方法
 * <p>
 * 一个线程可以在其他线程之上调用join()方法，效果是等待一段时间，直到第二个线程结束才继续执行。
 * <p>
 * 也可以在调用join()时带上一个超时参数(单位可以是毫秒，纳秒)，这样如果目标线程在这段时间到期时
 * 还没有结束的话，join()方法总能返回。
 */
public class Joining {
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("小明", 1500);
//        Sleeper grumpy = new Sleeper("小红", 1500);
        Joiner dopey = new Joiner("小强", sleepy);
//        Joiner doc = new Joiner("小张", grumpy);
//        sleepy.interrupt();
//        grumpy.interrupt();
        dopey.interrupt();
    }
}

class Sleeper extends Thread {
    private final int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + "被打断了。isInterrupted():" + isInterrupted());
            return;
        }
        System.out.println(getName() + "被唤醒（恢复）了。");
    }
}

class Joiner extends Thread {
    private final Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println(getName() + "被打断了！");
        }
        System.out.println(getName() + "join()完成");
    }
}