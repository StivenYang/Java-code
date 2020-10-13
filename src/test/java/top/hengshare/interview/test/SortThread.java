package top.hengshare.interview.test;

import static java.lang.Thread.sleep;

public class SortThread implements Runnable {
    private final String num;

    public SortThread(final String num) {
        this.num = num + "";
    }

    public static void main(final String[] args) {
        final int[] numbers = { 11, 3, 998, 5455, 1, 152, 990 };
        for (int i = 0; i < numbers.length; i++) {
            new Thread(new SortThread(String.valueOf(numbers[i]))).start();
        }
    }

    @Override
    public void run() {
        try {
            sleep(Integer.parseInt(num));
            System.out.println(num);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
}
