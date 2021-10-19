package top.hengshare.interview.pattern.visitor.example;

import lombok.Data;

/**
 * @program: Java-Interview
 * @description: EnterpriseCustomner
 * @author: StivenYang
 * @create: 2019-11-03 19:12
 **/
@Data
public class EnterpriseCustomner extends Customer {
	/**
	 * 联系人
	 */
	private String linkman;
	/**
	 * 联系电话
	 */
	private String linkTelephone;
	/**
	 * 企业注册地址
	 */
	private String registerAddress;

	@Override
	public void serviceRequest() {
		System.out.println(this.getName() + "企业提出服务请求");
	}

	@Override
	public void predilectionAnalyze() {
		System.out.println("现在对企业客户" + this.getName() + "进行产品偏好分析");
	}

	@Override
	public void worthAnalyze() {
		System.out.println("现在对企业客户" + this.getName() + "进行价值分析");
	}
}
