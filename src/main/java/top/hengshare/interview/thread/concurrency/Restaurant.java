package top.hengshare.interview.thread.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author StivenYang
 * @program interview
 * @description 生产者与消费者
 * @date 2019-07-07 15:20
 **/
public class Restaurant {
    //订单
    Meal meal;
    //线程池
    ExecutorService exec = Executors.newCachedThreadPool();
    //厨师
    Chef chef = new Chef(this);
    //服务生
    WaitPerson waitPerson = new WaitPerson(this);

    //饭店开张的时候，安排一个服务生，一个客人
    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }

}

class Meal {
    //订单号
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "饭票{" +
                "订单号=" + orderNum +
                '}';
    }
}

class WaitPerson implements Runnable {
    //服务生所在的饭店
    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    //当还没有订单的时候，服务生可以先歇息
                    while (restaurant.meal == null) {
                        wait();
                    }
                }
                System.out.println("服务生拿到了菜:" + restaurant.meal);
                synchronized (restaurant.chef) {
                    //取完菜以后，将要取的菜设置为null
                    restaurant.meal = null;
                    //通知所有的厨师，已经拿到菜了，开始准备另外一道菜吧
                    restaurant.chef.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("服务生异常结束工作了");
        }
    }
}

class Chef implements Runnable {
    //服务员所属饭店
    private Restaurant restaurant;
    //服务员上菜数量
    private int count = 0;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    //当还没有上菜订单的时候，服务员等待
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                if (++count == 10) {
                    System.out.println("菜上齐了");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("订单来了");
                //服务生上菜，告诉客人上了一道菜了
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("厨师线程中断");
        }
    }
}
