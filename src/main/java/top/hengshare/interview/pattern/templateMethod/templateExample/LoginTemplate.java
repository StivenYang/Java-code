package top.hengshare.interview.pattern.templateMethod.templateExample;

/**
 * @program: Java-Interview
 * @description: 登录模板
 * @author: Steven Yang
 * @create: 2019-10-15 14:11
 **/
public abstract class LoginTemplate {
	public final boolean login(LoginModel lm) {
		LoginModel loginUser = findLoginUser(lm.getLoginId());
		if (loginUser != null) {
			String encryptPwd = this.encryptPwd(lm.getPwd());
			lm.setPwd(encryptPwd);
			return this.match(lm, loginUser);
		}
		return false;
	}

	public abstract LoginModel findLoginUser(String loginId);

	public String encryptPwd(String pwd) {
		return pwd;
	}

	public boolean match(LoginModel lm, LoginModel dbLm) {
		if (lm.getLoginId().equals(dbLm.getLoginId()) && lm.getPwd().equals(dbLm.getPwd())) {
			return true;
		}
		return false;
	}
}
