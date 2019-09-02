package top.hengshare.interview.thread.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author StivenYang
 * @program interview
 * @description 显示临界区 代码块
 * @date 2019-04-27 18:31
 **/
public class ExplicitCriticalSection {
    public static void main(String[] args) {
        ExplicitPairManager1 expm1 = new ExplicitPairManager1();
        ExplicitPairManager2 expm2 = new ExplicitPairManager2();
        CriticalSection.testApproaches(expm1, expm2);
    }
}

class ExplicitPairManager1 extends PairManager { //给整个方法加锁
    private Lock lock = new ReentrantLock();

    @Override
    public synchronized void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}

class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementY();
            p.incrementX();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}
