package top.hengshare.interview.pattern.chainOfResposiblity.common;

/**
 * @program: Java-Interview
 * @description: Client
 * @author: StivenYang
 * @create: 2019-11-01 15:21
 **/
public class Client2 {
	public static void main(String[] args) {
		//先要组装职责链
		Handler generalManager = new GeneralManager2();
		Handler depManager = new DepManager2();
		Handler projectManager = new ProjectManager2();

		projectManager.setSuccessor(depManager);
		depManager.setSuccessor(generalManager);

		//开始测试申请聚餐费用
		FeeRequestModel model = new FeeRequestModel();
		model.setFee(300);
		model.setUser("小李");
		String str1 = (String) projectManager.handleRequest(model);
		System.out.println(str1);

		model.setFee(800);
		model.setUser("小李");
		String str2 = (String) projectManager.handleRequest(model);
		System.out.println(str2);

		model.setFee(1200);
		model.setUser("小李");
		String str3 = (String) projectManager.handleRequest(model);
		System.out.println(str3);

		//开始测试申请预支差旅费用
		PreFeeRequestModel model2 = new PreFeeRequestModel();
		model2.setFee(3000);
		model2.setUser("小李");
		projectManager.handleRequest(model2);

		model2.setFee(8000);
		model2.setUser("小李");
		projectManager.handleRequest(model2);

		model2.setFee(12000);
		model2.setUser("小李");
		projectManager.handleRequest(model2);
	}
}
