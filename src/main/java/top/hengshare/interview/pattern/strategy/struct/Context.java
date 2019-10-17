package top.hengshare.interview.pattern.strategy.struct;

/**
 * @program: Java-Interview
 * @description: 上下文对象，通常会持有一个具体的策略对象
 * @author: Steven Yang
 * @create: 2019-10-16 09:02
 **/
public class Context {

    /**
     * 持有一个具体的策略对象
     */
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 上下文对客户端提供的操作接口
     */
    public void contextInterface() {
        //通常会转调具体的策略对象进行算法运算
        strategy.algorithmInterface();
    }
}
