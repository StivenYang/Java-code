package top.hengshare.interviewer.java8.ForkAndJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 分支合并框架代码
 * @author Yang
 */
public class ForkJoinSumCalculator extends RecursiveTask {

    private final long[] numbers;

    private final int start;

    private final int end;

    public static final long THRESHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        //如果小于或者等于阈值，顺序计算结果
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        //创建一个子任务来为数组的前一半求和
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        //使用子任务的fork分支方法异步执行子任务
        leftTask.fork();
        //再创建一个子任务来为数组的后一半求和
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        //同步执行第二个子任务，有可能允许进一步递归划分子任务
        Long rightResult = rightTask.compute();
        System.out.print(rightResult + "+");
        //读取第一个子任务的结果，如果尚未完成则等待
        Long leftResult = (Long) leftTask.join();
        System.out.println(leftResult);
        //该任务的结果是两个子任务的结构的和
        return rightResult + leftResult;
    }

    /**
     * 在子任务不可再划分的时候计算结果的简单算法
     * @return 一个长整型的值
     */
    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> calculator = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(calculator);
    }

    public static void main(String[] args) {
        System.out.println("start:");
        System.out.println("\n" + forkJoinSum(1_000_000));
        System.out.println("\nend.");
    }
}
