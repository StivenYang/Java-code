package top.hengshare.interview.pattern.templateMethod.example;

/**
 * @program: Java-Interview
 * @description: 普通用户登录逻辑
 * @author: Steven Yang
 * @create: 2019-10-15 13:24
 **/
public class NormalLogin {

    /**
     * @description: 登录方法
     * @params: [lm]
     * @return: boolean
     * @author: StevenYang
     * @create: 2019/10/15
     */
    public boolean login(NormalLoginModel lm) {
        //从数据库获取登录人员的信息
        UserModel user = this.findUserByUserId(lm.getUserId());
        //判断lm和user是否一致
        if (user != null) {
            return user.getPwd().equals(lm.getPwd()) && user.getUserId().equals(lm.getUserId());
        }
        return false;
    }

    /**
     * @description: 根据用户id查找用户信息
     * @params: 用户id
     * @return: 用户信息实体
     * @author: StevenYang
     * @create: 2019/10/15
     */
    private UserModel findUserByUserId(String userId) {
        UserModel userModel = new UserModel();
        userModel.setName("test");
        userModel.setPwd("test");
        userModel.setUserId(userId);
        userModel.setUuid("user001");
        return userModel;
    }
}
