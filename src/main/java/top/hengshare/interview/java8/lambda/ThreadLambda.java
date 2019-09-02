package top.hengshare.interview.java8.lambda;

public class ThreadLambda {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("hello world"));
        t.start();
    }
}
