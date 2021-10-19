package top.hengshare.interview.pattern.visitor.example;

/**
 * @program: Java-Interview
 * @description: PersonalCustomer
 * @author: StivenYang
 * @create: 2019-11-03 19:23
 **/
public class PersonalCustomer extends Customer {

	/**
	 * 电话号码
	 */
	private String telephone;

	/**
	 * 年龄
	 */
	private int age;

	@Override
	public void serviceRequest() {
		System.out.println("客户" + this.getName() + "提出服务请求");
	}

	@Override
	public void predilectionAnalyze() {
		System.out.println("现在对个人客户" + this.getName() + "进行产品偏好分析");
	}

	@Override
	public void worthAnalyze() {
		System.out.println("现在对个人客户" + this.getName() + "进行价值分析");
	}
}
