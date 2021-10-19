package top.hengshare.interview.pattern.strategy.price;

/**
 * @program: Java-Interview
 * @description: 普通客户策略
 * @author: Steven Yang
 * @create: 2019-10-16 09:16
 **/
public class NormalCustomerStrategy implements Strategy {

	@Override
	public double calcPrice(double goodsPrice) {
		System.out.println("针对普通客户没有折扣");
		return goodsPrice;
	}
}
