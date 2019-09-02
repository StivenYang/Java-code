package top.hengshare.interview.thread.concurrency.ThreadPoolDemo;

/**
 * @author StivenYang
 * @program interview
 * @description 计算逻辑1
 * @date 2019-06-11 10:38
 **/
public class Index1 implements Indexalculation {

    @Override
    public Result calculation(Object obj) {
        System.out.println("计算逻辑1");
        Result result = new Result();
        result.setStr("计算逻辑1");
        return result;
    }

}
