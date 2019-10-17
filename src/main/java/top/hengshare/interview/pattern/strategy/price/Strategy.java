package top.hengshare.interview.pattern.strategy.price;

/**
 * @program: Java-Interview
 * @description: 计算报价算法接口
 * @author: Steven Yang
 * @create: 2019-10-16 09:14
 **/
public interface Strategy {
    /**
     * 计算报价
     * @param goodsPrice 客户销售原价
     * @return 计算出来应报价格
     */
    double calcPrice(double goodsPrice);
}
