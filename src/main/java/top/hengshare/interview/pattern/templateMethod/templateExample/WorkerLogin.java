package top.hengshare.interview.pattern.templateMethod.templateExample;

/**
 * @program: Java-Interview
 * @description: 工作人员登录控制类
 * @author: Steven Yang
 * @create: 2019-10-15 14:21
 **/
public class WorkerLogin extends LoginTemplate {


	@Override
	public LoginModel findLoginUser(String loginId) {
		LoginModel model = new LoginModel();
		model.setPwd("admin");
		model.setLoginId(loginId);
		return model;
	}

	@Override
	public String encryptPwd(String pwd) {
		System.out.println("使用md5加密了");
		return pwd;
	}
}
