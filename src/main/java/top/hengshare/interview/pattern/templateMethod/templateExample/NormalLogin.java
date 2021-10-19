package top.hengshare.interview.pattern.templateMethod.templateExample;

/**
 * @program: Java-Interview
 * @description: 普通用户登录实现类
 * @author: Steven Yang
 * @create: 2019-10-15 14:18
 **/
public class NormalLogin extends LoginTemplate {

	@Override
	public LoginModel findLoginUser(String loginId) {
		LoginModel model = new LoginModel();
		model.setPwd("admin");
		model.setLoginId(loginId);
		return model;
	}
}
