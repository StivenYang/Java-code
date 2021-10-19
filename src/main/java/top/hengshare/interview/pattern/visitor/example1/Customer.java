package top.hengshare.interview.pattern.visitor.example1;

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
	 * 接受访问者的访问
	 * @param visitor 访问者对象
	 */
	public abstract void accept(Visitor visitor);

}
