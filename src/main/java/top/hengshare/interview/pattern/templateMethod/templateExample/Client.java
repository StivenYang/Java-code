package top.hengshare.interview.pattern.templateMethod.templateExample;

/**
 * @program: Java-Interview
 * @description: 客户端类，测试模板方法
 * @author: Steven Yang
 * @create: 2019-10-15 14:23
 **/
public class Client {
	public static void main(String[] args) {
		//准备登录人的信息
		LoginModel lm = new LoginModel();
		lm.setLoginId("admin");
		lm.setPwd("admin");

		//准备用来判断的对象
		WorkerLogin workerLogin = new WorkerLogin();
		NormalLogin normalLogin = new NormalLogin();

		//进行登录测试
		boolean flag = workerLogin.login(lm);
		System.out.println("可以登录工作平台=" + flag);

		boolean login = normalLogin.login(lm);
		System.out.println("可以进行普通人员登录=" + login);

	}
}
