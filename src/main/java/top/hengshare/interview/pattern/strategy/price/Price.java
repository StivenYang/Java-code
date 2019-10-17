package top.hengshare.interview.pattern.strategy.price;

/**
 * @program: Java-Interview
 * @description: 价格管理
 * @author: Steven Yang
 * @create: 2019-10-16 09:20
 **/
public class Price {

    private Strategy strategy;

    public Price(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 报价
     * @param goodsPrice 商品市场价格
     * @return 应报价格
     */
    public double quote(double goodsPrice){
        return this.strategy.calcPrice(goodsPrice);
    }
}
