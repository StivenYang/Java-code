package top.hengshare.interview.test;

import org.junit.Test;

public class SortThread implements Runnable {
    private String num;

    public SortThread(String num) {
        this.num = num + "";
    }

    public static void main(String[] args) {
        int[] numbers = {11, 3, 998, 5455, 1, 152, 990};
        for (int i = 0; i < numbers.length; i++) {
            new Thread(new SortThread(String.valueOf(numbers[i]))).start();
        }
    }


    @Override
    public void run() {
        try {
            Thread.sleep(Integer.parseInt(num));
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
