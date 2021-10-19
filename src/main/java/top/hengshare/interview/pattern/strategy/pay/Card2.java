package top.hengshare.interview.pattern.strategy.pay;

/**
 * @program: Java-Interview
 * @description: 策略模式扩展2：给策略传参进行扩展
 * @author: Steven Yang
 * @create: 2019-10-16 10:02
 **/
public class Card2 implements PaymentStrategy {

	/**
	 * 银行账户
	 */
	private String account;

	public Card2(String account) {
		this.account = account;
	}

	@Override
	public void pay(PaymentContext ctx) {
		System.out.println("现在给：" + ctx.getUsername() + " 的卡号为：" + this.account + " 的卡发放工资：" + ctx.getMoney());
	}
}
