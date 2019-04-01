package top.hengshare.interviewer.thread.concurrency;

import java.io.IOException;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/31
 * @description:
 */
public class UnresponsiveUI {
    private volatile double d = 1;

    public UnresponsiveUI() throws IOException {
        while (d > 0) {
            d=d+(Math.PI+Math.E)/d;
        }
        System.in.read();
    }

    public static void main(String[] args) throws IOException {
        new UnresponsiveUI();
    }
}

class ResponsiveUI extends Thread{
    private static double d = 1;

    public ResponsiveUI(){
        setDaemon(true);
        start();
    }
    @Override
    public void run(){
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws IOException {
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}