package top.hengshare.interview.pattern.visitor.example;

import lombok.Data;

/**
 * @program: Java-Interview
 * @description: Customer
 * @author: StivenYang
 * @create: 2019-11-03 19:09
 **/
@Data
public abstract class Customer {
	/**
	 * 客户编号
	 */
	private String customerId;
	/**
	 * 客户名称
	 */
	private String name;

	/**
	 * 客户提出服务请求的方法，示意一下
	 */
	public abstract void serviceRequest();

	/**
	 * 客户对公司产品的偏好分析
	 */
	public abstract void predilectionAnalyze();

	/**
	 * 客户价值分析
	 */
	public abstract void worthAnalyze();

}
