package top.hengshare.interview.pattern.strategy.pay;

import lombok.Getter;

/**
 * @program: Java-Interview
 * @description: 支付工资的上下文
 * @author: Steven Yang
 * @create: 2019-10-16 09:40
 **/
public class PaymentContext {

	/**
	 * 要支付工资的员工姓名
	 */
	@Getter
	private String username;

	/**
	 * 应支付的金额
	 */
	@Getter
	private double money = 0.0;

	/**
	 * 工资发放策略
	 */
	private PaymentStrategy strategy;

	public PaymentContext(String username, double money, PaymentStrategy strategy) {
		this.username = username;
		this.money = money;
		this.strategy = strategy;
	}

	/**
	 * 立即支付工资
	 */
	public void payNow() {
		this.strategy.pay(this);
	}
}
