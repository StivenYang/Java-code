package top.hengshare.interview.pattern.visitor.example1;

/**
 * @program: Java-Interview
 * @description: ServiceRequestVisitor
 * @author: StivenYang
 * @create: 2019-11-03 19:35
 **/
public class PredilectionAnalyzeVisitor implements Visitor {
	@Override
	public void visitEnterpriseCustomer(EnterpriseCustomer customer) {
		//企业客户提出的具体服务请求
		System.out.println("现在对企业客户" + customer.getName() + "进行产品偏好分析");
	}

	@Override
	public void visitPersonCustomer(PersonalCustomer customer) {
		//个人客户提出的具体服务请求
		System.out.println("现在对个人客户" + customer.getName() + "进行产品偏好分析");
	}
}
