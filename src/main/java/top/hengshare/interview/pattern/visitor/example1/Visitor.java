package top.hengshare.interview.pattern.visitor.example1;

/**
 * @program: Java-Interview
 * @description: Visitor
 * @author: StivenYang
 * @create: 2019-11-03 19:32
 **/
public interface Visitor {

	/**
	 * 访问企业客户
	 * @param customer 企业客户对象
	 */
	void visitEnterpriseCustomer(EnterpriseCustomer customer);

	/**
	 * 访问个人客户
	 * @param customer 个人客户对象
	 */
	void visitPersonCustomer(PersonalCustomer customer);
}
