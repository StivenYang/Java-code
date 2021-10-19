package top.hengshare.interview.pattern.visitor.example1;

/**
 * @program: Java-Interview
 * @description: ServiceRequestVisitor
 * @author: StivenYang
 * @create: 2019-11-03 19:35
 **/
public class ServiceRequestVisitor implements Visitor {
	@Override
	public void visitEnterpriseCustomer(EnterpriseCustomer customer) {
		//企业客户提出的具体服务请求
		System.out.println(customer.getName() + "企业提出具体服务请求");
	}

	@Override
	public void visitPersonCustomer(PersonalCustomer customer) {
		//个人客户提出的具体服务请求
		System.out.println(customer.getName() + "个人提出具体服务请求");
	}
}
