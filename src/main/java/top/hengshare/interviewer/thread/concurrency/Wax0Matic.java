package top.hengshare.interviewer.thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author StivenYang
 * @program interview
 * @description 线程之间的协作
 * @date 2019-07-07 13:25
 **/
public class Wax0Matic {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}

class Car {
    private boolean waxOn = false;

    public synchronized void waxed() {
        //准备图蜡
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffed() {
        //图蜡
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        //等待抛光
        while (waxOn == false) {
            wait();
        }
    }

    public synchronized void waitForBuffed() throws InterruptedException {
        //等待图蜡
        while (waxOn == true) {
            wait();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("抛光开始");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffed();
            }
        } catch (InterruptedException e) {
            System.out.println("退出 by Interrupt");
        }
        System.out.println("结束wax");
    }
}

class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("抛光结束");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("退出 by interrupt");
        }
        System.out.println("结束wax");
    }
}
