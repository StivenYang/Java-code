package top.hengshare.interview.pattern.strategy.price;

/**
 * @program: Java-Interview
 * @description: 针对老客户策略
 * @author: Steven Yang
 * @create: 2019-10-16 09:17
 **/
public class OldCustomerStrategy implements Strategy {
    @Override
    public double calcPrice(double goodsPrice) {
        System.out.println("针对老客户，折扣5%");
        return goodsPrice * (1 - 0.05);
    }
}
