package top.hengshare.interview.pattern.proxy.dynamicProxy;

import top.hengshare.interview.pattern.proxy.protectProxy.Order;
import top.hengshare.interview.pattern.proxy.protectProxy.OrderAPI;

public class Client {
	public static void main(String[] args) {
		//张三创建一个订单
		Order order = new Order("设计模式", 100, "张三");

		//创建了一个动态代理，通过动态代理，我们不需要像在静态代理中那样在每个setter方法中对参数进行判断了
		DynamicProxy dynamicProxy = new DynamicProxy();
		OrderAPI orderAPI = dynamicProxy.getProxyInterface(order);

		//使用绑定了订单对象的代理来对订单进行操作
		orderAPI.setOrderNum(123, "李四");
		System.out.println(orderAPI);
		orderAPI.setOrderNum(234, "张三");
		System.out.println(orderAPI);

	}
}
