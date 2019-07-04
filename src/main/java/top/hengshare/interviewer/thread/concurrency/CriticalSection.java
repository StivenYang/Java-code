package top.hengshare.interviewer.thread.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author StivenYang
 * @program interview
 * @description 使用临界区来取代在方法上使用sychronized
 * @date 2019-04-27 17:24
 * 通过使用同步控制块，而不是对整个方法进行同步控制，可以使多个任务访问对象的时间性能显著提高。
 * 下面的代码演示了两个不同的控制方法。
 * 此外，他也演示了如何把一个非保护类型的类，在其他类的保护和控制之下，应用于多线程的环境中
 *
 * 结论：请更多的使用局部块进行同步控制
 **/
public class CriticalSection {
    //测试这两种不同的线程安全方式
    static void testApproaches(PairManager pman1, PairManager pman2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator pm1 = new PairManipulator(pman1);
        PairManipulator pm2 = new PairManipulator(pman2);
        PairChecker pChecker1 = new PairChecker(pman1);
        PairChecker pChecker2 = new PairChecker(pman2);
        exec.execute(pm1);
        exec.execute(pm2);
        exec.execute(pChecker1);
        exec.execute(pChecker2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("睡眠被打断");
        }
        System.out.println("pm1: " + pm1 + "\n pm2: " + pm2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager1 pman1 = new PairManager1();
        PairManager2 pman2 = new PairManager2();
        testApproaches(pman1, pman2);
    }
}

class Pair { //非线程安全的一个类
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        this.x++;
    }

    public void incrementY() {
        this.y++;
    }

    public String toString() {
        return "x=" + x + "; y=" + y;
    }

    public class PairValuesNotEqualException extends RuntimeException {
        public PairValuesNotEqualException() {
            super("Pair 的值不相等：" + Pair.this);
        }
    }

    public void checkStatus() {
        if (x != y) {
            throw new PairValuesNotEqualException();
        }
    }
}

abstract class PairManager { //内置了一个线程安全的类来保护Pair这个非线程安全的类
    AtomicInteger checkCounter = new AtomicInteger(0);
    protected Pair p = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair() {
        //返回一个Pair的副本，确保原pair对象安全
        return new Pair(p.getX(), p.getY());
    }

    // 假定这是一个时间消费的操作
    protected void store(Pair pair) {
        storage.add(pair);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void increment();
}

class PairManager1 extends PairManager { //同步整个方法

    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}

class PairManager2 extends PairManager { //同步关键部分
    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementY();
            p.incrementX();
            temp = getPair();
        }
        store(temp);
    }
}

class PairManipulator implements Runnable { //Pair机械手
    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "pair: " + pm.getPair() + "; checkCounter: " + pm.checkCounter.get();
    }
}

class PairChecker implements Runnable { //Pair检查者
    private PairManager pm;
    PairChecker(PairManager pm) {
        this.pm = pm;
    }

    @Override
    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkStatus();
        }
    }
}
