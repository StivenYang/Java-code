package top.hengshare.interview.pattern.templateMethod.callbak;

import top.hengshare.interview.pattern.templateMethod.templateExample.LoginModel;

/**
 * @program: Java-Interview
 * @description: 登录控制的模板方法需要的回调接口，需要把所有需要的接口方法都定义出来
 * @author: Steven Yang
 * @create: 2019-10-15 17:29
 **/
public interface LoginCallbak {

	/**
	 * 根据登录编号来查找登录用户的信息
	 * @param loginId 登录编号
	 * @return 登录用户信息
	 */
	LoginModel findLoginUser(String loginId);

	/**
	 * 对密码进行加密
	 * @param pwd 密码数据
	 * @param template loginTemplate对象，通过它来调用在loginTemplate中定义的公共方法或默认实现
	 * @return 加密后的密码
	 */
	String encryptPwd(String pwd, LoginTemplate template);

	/**
	 * 判断用户填写的登录数据和存储中对应的数据是否匹配的上
	 * @param lm 用户填写的登录数据
	 * @param dbLm 在存储中对应的数据
	 * @param template 通过template调用在LoginTemplate中定义的公共方法或默认实现
	 * @return true表示匹配成功，false表示匹配失败
	 */
	boolean match(LoginModel lm, LoginModel dbLm, LoginTemplate template);

}
