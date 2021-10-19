package top.hengshare.interview.pattern.proxy.dynamicProxy;


import org.apache.commons.lang3.StringUtils;
import top.hengshare.interview.pattern.proxy.protectProxy.Order;
import top.hengshare.interview.pattern.proxy.protectProxy.OrderAPI;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

	private OrderAPI order;

	public OrderAPI getProxyInterface(Order order) {
		//设置被代理的对象，方便获取被代理对象里面的方法
		this.order = order;
		//把真正的订单对象和动态代理关联起来
		OrderAPI orderAPI = (OrderAPI) Proxy
				.newProxyInstance(order.getClass().getClassLoader(), order.getClass().getInterfaces(), this);
		return orderAPI;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//如果是调用set方法就需要检查权限
		if (method.getName().startsWith("set")) {
			//如果不是创建人，就不能修改
			if (StringUtils.isNotEmpty(order.getOrderUser()) && order.getOrderUser().equals(args[1])) {
				//可以操作
				return method.invoke(order, args);
			} else {
				//无权操作
				System.out.println("无权操作");
			}
		} else {
			//不是调用的setter方法，就放行
			return method.invoke(order, args);
		}

		return null;
	}
}
