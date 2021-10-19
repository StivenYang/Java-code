package top.hengshare.interview.pattern.strategy.pay;

/**
 * @program: Java-Interview
 * @description: 银行卡发放工资策略
 * @author: Steven Yang
 * @create: 2019-10-16 09:54
 **/
public class Card implements PaymentStrategy {
	@Override
	public void pay(PaymentContext ctx) {
		PaymentContext2 ctx2 = (PaymentContext2) ctx;
		System.out.println("现在给：" + ctx2.getUsername() + " 的卡号为：" + ctx2.getAccount() + " 的卡发放工资：" + ctx2.getMoney());
	}
}
