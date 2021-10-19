package top.hengshare.interview.pattern.proxy.jdkproxy;

/**
 * @author yang
 */
public class ProxyTest {
	public static void main(String[] args) {
		//实例化目标对象
		UserService userService = new UserServiceImpl();

		//实例化调用处理器
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler(userService);

		//从调用处理器中获取代理对象
		UserService proxy = (UserService) myInvocationHandler.getProxy();

		//调用代理对象的方法
		proxy.add();
		proxy.delete();
	}
}
