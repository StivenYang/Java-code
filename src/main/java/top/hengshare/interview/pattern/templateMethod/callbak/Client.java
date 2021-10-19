package top.hengshare.interview.pattern.templateMethod.callbak;

import top.hengshare.interview.pattern.templateMethod.templateExample.LoginModel;

/**
 * @program: Java-Interview
 * @description: 验证模板方法的回调使用方法
 * @author: Steven Yang
 * @create: 2019-10-15 18:07
 **/
public class Client {
	public static void main(String[] args) {
		//准备登录人的信息
		LoginModel loginModel = new LoginModel();
		loginModel.setLoginId("admin");
		loginModel.setPwd("admin");

		//准备用来判断的对象
		LoginTemplate template = new LoginTemplate();

		//登录
		boolean login = template.login(loginModel, new LoginCallbak() {
			@Override
			public LoginModel findLoginUser(String loginId) {
				//相当于查数据库
				LoginModel lm = new LoginModel();
				lm.setPwd("admin");
				lm.setLoginId("admin");
				return lm;
			}

			@Override
			public String encryptPwd(String pwd, LoginTemplate template) {
				return template.encryptPwd(pwd);
			}

			@Override
			public boolean match(LoginModel lm, LoginModel dbLm, LoginTemplate template) {
				return template.match(lm, dbLm);
			}
		});
		System.out.println("进行普通人员登录：" + login);


		//测试工作人员登录
		boolean workerLogin = template.login(loginModel, new LoginCallbak() {
			@Override
			public LoginModel findLoginUser(String loginId) {
				LoginModel worker = new LoginModel();
				worker.setLoginId("admin");
				worker.setPwd("admin");
				return worker;
			}

			@Override
			public String encryptPwd(String pwd, LoginTemplate template) {
				System.out.println("这里进行md5进行加密");
				return template.encryptPwd(pwd);
			}

			@Override
			public boolean match(LoginModel lm, LoginModel dbLm, LoginTemplate template) {
				return template.match(lm, dbLm);
			}
		});
		System.out.println("进行工作人员登录：" + workerLogin);
	}
}
