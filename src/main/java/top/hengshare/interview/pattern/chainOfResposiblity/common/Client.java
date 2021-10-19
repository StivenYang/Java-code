package top.hengshare.interview.pattern.chainOfResposiblity.common;

/**
 * @program: Java-Interview
 * @description: Client
 * @author: StivenYang
 * @create: 2019-11-01 15:21
 **/
public class Client {
	public static void main(String[] args) {
		//先要组装职责链
		GeneralManager generalManager = new GeneralManager();
		DepManager depManager = new DepManager();
		ProjectManager projectManager = new ProjectManager();

		projectManager.setSuccessor(depManager);
		depManager.setSuccessor(generalManager);

		//开始测试申请聚餐费用
		FeeRequestModel model = new FeeRequestModel();
		model.setFee(300);
		model.setUser("小李");
		//调用处理
		String str1 = (String) projectManager.handleRequest(model);
		System.out.println(str1);

		model.setFee(800);
		model.setUser("小李");
		//调用处理
		String str2 = (String) projectManager.handleRequest(model);
		System.out.println(str2);

		model.setFee(1200);
		model.setUser("小李");
		//调用处理
		String str3 = (String) projectManager.handleRequest(model);
		System.out.println(str3);
	}
}
