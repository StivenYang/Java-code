package top.hengshare.interview.pattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

	/**
	 * 目标对象
	 */
	private Object target;

	public MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	/**
	 * 执行目标对象的方法
	 *
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 在目标对象的方法执行之前简单打印一下
		System.out.println("-------before------");

		// 执行目标对象的方法
		Object result = method.invoke(target, args);

		// 之后打印
		System.out.println("-------after-------");

		return result;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(),
				this);
	}
}
