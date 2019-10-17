package top.hengshare.interview.pattern.strategy.price;

/**
 * @program: Java-Interview
 * @description: 针对大客户的策略
 * @author: Steven Yang
 * @create: 2019-10-16 09:19
 **/
public class LargeCustomerStrategy implements Strategy {
    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("对于大客户，折扣10%");
        return goodsPrice * (1 - 0.1);
    }
}
