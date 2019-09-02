package top.hengshare.interview.thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author StivenYang
 * @program interview
 * @description 显式Lock和Condition、signal、signalAll
 * @date 2019-07-07 19:06
 **/
public class Wax0matic2 {
    public static void main(String[] args) throws InterruptedException {
        Car2 car2 = new Car2();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff2(car2));
        exec.execute(new WaxOn2(car2));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}

class Car2 {
    private boolean waxOn = false;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waxed() {
        lock.lock();
        try {
            waxOn = true;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void buffed() {
        lock.lock();
        try {
            waxOn = false;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void waitForWaxing() throws InterruptedException {
        lock.lock();
        try {
            while (!waxOn) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public void waitForBuffing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }
}

class WaxOn2 implements Runnable {
    private Car2 car2;

    public WaxOn2(Car2 car2) {
        this.car2 = car2;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("wax on");
                TimeUnit.MILLISECONDS.sleep(100);
                car2.waxed();
                car2.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("exit waxOn by interrupt");
        }
        System.out.println("ending wax on task");
    }
}

class WaxOff2 implements Runnable {
    private Car2 car2;

    public WaxOff2(Car2 car2) {
        this.car2 = car2;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("wax off");
                TimeUnit.MILLISECONDS.sleep(100);
                car2.buffed();
                car2.waitForWaxing();
            }
        } catch (InterruptedException e) {
            System.out.println("exit waxoff by interrupt");
        }
        System.out.println("ending wax off task");
    }
}
