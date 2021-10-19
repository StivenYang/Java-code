package top.hengshare.interview.pattern.prototype.javaClone;

public class Client {
	public static void main(String[] args) {
		//个人
		//创建订单对象
		PersonalOrder order1 = new PersonalOrder();
		//设置订单数据
		order1.setOrderProductNum(2185);
		System.out.println("这是第一次获取的对象实例==" + order1.getOrderProductNum());
		//通过克隆来获取对象的实例
		PersonalOrder order2 = (PersonalOrder) order1.clone();
		order2.setOrderProductNum(90);
		System.out.println("这是通过克隆得到的对象实例==" + order2.getOrderProductNum());
		System.out.println("再次输出原来实例的值==" + order1.getOrderProductNum());

		//企业
		//创建订单对象
		EnterpriseOrder order3 = new EnterpriseOrder();
		//设置订单数据
		order3.setOrderProductNum(100);
		System.out.println("这是第一次获取的对象实例==" + order3.getOrderProductNum());
		//通过克隆来获取对象的实例
		EnterpriseOrder order4 = (EnterpriseOrder) order3.clone();
		order4.setOrderProductNum(90);
		System.out.println("这是通过克隆得到的对象实例==" + order4.getOrderProductNum());
		System.out.println("再次输出原来实例的值==" + order3.getOrderProductNum());
	}
}
