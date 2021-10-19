package top.hengshare.interview.pattern.strategy.pay;

import lombok.Getter;

/**
 * @program: Java-Interview
 * @description: 向银行卡支付工资，而不是发放现金
 * @author: Steven Yang
 * @create: 2019-10-16 09:52
 **/
public class PaymentContext2 extends PaymentContext {

	/**
	 * 银行卡账号
	 */
	@Getter
	private String account;

	public PaymentContext2(String username, double money, String account, PaymentStrategy strategy) {
		super(username, money, strategy);
		this.account = account;
	}
}
