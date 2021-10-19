package top.hengshare.interview.pattern.builder.complexExample;

public class Client {
	public static void main(String[] args) {
		//创建构建器
		ConcreteBuilder builder = new ConcreteBuilder("001", 1234L, 345L);
		//设置选填数据，然后构建对象
		InsuranceContract contract = builder.setPersonName("张三").setOtherData("test").build();
		//操作构建出来的对象
		contract.someOperation();
	}
}
