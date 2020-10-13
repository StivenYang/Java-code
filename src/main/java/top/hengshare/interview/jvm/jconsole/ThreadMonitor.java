package top.hengshare.interview.jvm.jconsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadMonitor {

    /**
     * 线程死循环演示
     */
    public static void createBusyThread(){
        new Thread(() -> {
            try {
                int n=1;
                while (true){
                    Thread.sleep(1000);
                    n++;
                    System.out.println("dead loop");
                    if (n > 10) {
                        return;
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }, "testBusyThread").start();

    }

    /**
     * 线程锁等待演示
     * @param lock
     */
    public static void createLockThread(final Object lock){
        new Thread(() -> {
            synchronized (lock){
                try {
                    lock.wait(1000);
                    System.out.println("object.lock.wait()");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }, "testLockThread").start();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        createBusyThread();
        reader.readLine();
        Object o = new Object();
        createLockThread(o);
    }
}
