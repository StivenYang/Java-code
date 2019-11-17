package top.hengshare.interview.generic.simple.interfaces;

/**
 * @program: Java-Interview
 * @description: Fibonacci
 * @author: StivenYang
 * @create: 2019-11-17 15:20
 **/
public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }

    private Integer fib(int i) {
        if (i < 2) {
            return 1;
        }
        return fib(i - 2) + fib(i - 1);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i=0; i<18; i++){
            System.out.println(fibonacci.next()+" ");
        }
    }
}
