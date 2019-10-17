package top.hengshare.interview.pattern.strategy.pay;

/**
 * @program: Java-Interview
 * @description: 支付工资的策略接口，公司有多种支付工资的算法
 * @author: Steven Yang
 * @create: 2019-10-16 09:38
 **/
public interface PaymentStrategy {
    /**
     * 公司给某人真正支付工资
     * @param ctx 支付工资的上下文
     */
    void pay(PaymentContext ctx);
}
