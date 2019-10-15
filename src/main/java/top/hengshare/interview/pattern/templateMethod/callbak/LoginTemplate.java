package top.hengshare.interview.pattern.templateMethod.callbak;

import top.hengshare.interview.pattern.templateMethod.templateExample.LoginModel;

/**
 * @program: Java-Interview
 * @description: 登录控制的模板
 * @author: Steven Yang
 * @create: 2019-10-15 17:39
 **/
public class LoginTemplate {

    /**
     * 是否登录成功
     *
     * @param lm      登录用户数据
     * @param callbak 回调接口
     * @return true表示成功，false表示失败
     */
    public final boolean login(LoginModel lm, LoginCallbak callbak) {
        //根据登录人员的编号去获取相应的数据
        LoginModel loginUser = callbak.findLoginUser(lm.getLoginId());
        if (loginUser != null) {
            //对密码进行加密
            String encryptPwd = callbak.encryptPwd(lm.getPwd(), this);
            //把加密后的密码设置回到登录数据类型中
            lm.setPwd(encryptPwd);
            //判断是否匹配
            return callbak.match(lm, loginUser, this);
        }
        return false;
    }

    /**
     * 对密码进行加密
     *
     * @param pwd 密码
     * @return 加密后的密码
     */
    public String encryptPwd(String pwd) {
        return pwd;
    }

    /**
     * 验证用户信息是否匹配
     *
     * @param lm   登录用户
     * @param dbLm 数据库用户
     * @return true表示匹配，false表示不匹配
     */
    public boolean match(LoginModel lm, LoginModel dbLm) {
        if (lm.getLoginId().equals(dbLm.getLoginId())
                && lm.getPwd().equals(dbLm.getPwd())) {
            return true;
        }
        return false;
    }
}
