package top.hengshare.interviewer.thread.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author StivenYang
 * @program interview
 * @description 创建一个辐射计数器，它可以具有任意数量的传感器
 * @date 2019-06-30 15:34
 **/
class RadCount {
    private int count = 0;
    private Random rand = new Random();
    public synchronized int increment() {
        return count++;
    }
    public synchronized int value() { return count; }
}

class Sensor implements Runnable {
    private static RadCount count = new RadCount();
    private static List<Sensor> sensors = new ArrayList<Sensor>();
    private int number = 0;
    // Doesn't need synchronization to read:
    private final int id;
    private static volatile boolean canceled = false;
    // Atomic operation on a volatile field:
    public static void cancel() { canceled = true; }
    public Sensor(int id) {
        this.id = id;
        // Keep this task in a list. Also prevents
        // garbage collection of dead tasks:
        sensors.add(this);
    }
    public void run() {
        while(!canceled) {
            synchronized(this) {
                ++number;
            }
            System.out.println(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(25);
            } catch(InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
        System.out.println("Stopping " + this);
    }
    public synchronized int getValue() { return number; }
    @Override
    public String toString() {
        return "Sensor " + id + ": " + getValue();
    }
    public static int getTotalCount() {
        return count.value();
    }
    public static int sumSensors() {
        int sum = 0;
        for(Sensor sensor : sensors)
            sum += sensor.getValue();
        return sum;
    }
}

public class RadiationCounter17 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++)
            exec.execute(new Sensor(i));
        // Run for a while, then stop and collect the data:
        TimeUnit.SECONDS.sleep(4);
        Sensor.cancel();
        exec.shutdown();
        if(!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
            System.out.println("Some tasks were not terminated");
        System.out.println("Total: " + Sensor.getTotalCount());
        System.out.println("Sum of Sensors: " + Sensor.sumSensors());
    }
}
