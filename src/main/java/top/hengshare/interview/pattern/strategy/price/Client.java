package top.hengshare.interview.pattern.strategy.price;

/**
 * @program: Java-Interview
 * @description: 测试报价系统
 * @author: Steven Yang
 * @create: 2019-10-16 09:22
 **/
public class Client {
	public static void main(String[] args) {
		//创建策略对象
		LargeCustomerStrategy strategy = new LargeCustomerStrategy();

		//创建上下文
		Price price = new Price(strategy);
		//计算报价
		double quote = price.quote(100);

		System.out.println("向客户报价：" + quote);
	}
}
