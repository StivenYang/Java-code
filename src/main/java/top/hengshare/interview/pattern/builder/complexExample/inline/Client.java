package top.hengshare.interview.pattern.builder.complexExample.inline;

public class Client {
	public static void main(String[] args) {
		//创建构建器
		InsuranceContract.ConcreteBuilder builder = new InsuranceContract.ConcreteBuilder("001", 12345L, 45678L);
		//设置数据
		InsuranceContract contract = builder.setPersonName("张三").setOtherData("test").build();
		//操作保险合同对象的方法
		contract.someOperation();
	}
}
