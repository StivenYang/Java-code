package top.hengshare.interviewer.thread.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

/**
 * @author StivenYang
 * @program interview
 * @description 生产者-消费者队列
 * @date 2019-07-09 16:08
 *
 * <p>wait和notify在比较低级的层面解决了任务之间的互操作问题，即每次交互的时候都握手</p>
 * <p>为了在更高的抽象级别，可以使用消息同步队列来解决任务协作的问题，同步队列在任何时刻都只允许一个任务</p>
 * <p>可以使用BlockingQueue接口提供的队列，具体的实现有两个：LinkedBlockingQueue和ArrayBlockingQueue两个</p>
 * <p>linked是无界的，而array是有界的，超过队列长度，线程就会被阻塞挂起</p>
 * <p>如果消费者任务试图从队列中获取对象，而该队列此时为空，那么这些队列还可以挂起消费者任务，并且当有更多的
 * 元素可用时恢复消费者任务。阻塞队列可以解决非常大量的问题，而其方式与wait()和notifyAll()相比，则简单可靠的多</p>
 **/
public class TestBlockingQueues {

    static void getKey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void getKey(String message) {
        System.out.println(message);
        getKey();
    }

    static void test(String msg, BlockingQueue<LiffOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i < 5; i++) {
            runner.add(new LiffOff(5));
        }
        getKey("输入Enter：" + msg);
        t.interrupt();
        System.out.println("完成测试：" + msg);
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingDeque<LiffOff>());
        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiffOff>(3));
        test("SynchronousQueue", new SynchronousQueue<LiffOff>());
    }
}


/**
 * 入队
 */
class LiftOffRunner implements Runnable {
    private BlockingQueue<LiffOff> rockets;

    public LiftOffRunner(BlockingQueue<LiffOff> queue) {
        rockets = queue;
    }

    public void add(LiffOff lo) {
        try {
            rockets.put(lo);
        } catch (InterruptedException e) {
            System.out.println("put()入队时异常");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiffOff rocket = rockets.take();
                rocket.run();
            }
        } catch (InterruptedException e) {
            System.out.println("从take()中抛出异常");
        }
        System.out.println("退出LiftOffRunner");
    }
}
