package top.hengshare.interview.pattern.templateMethod.example;

import top.hengshare.interview.netty.Worker;

/**
 * @program: Java-Interview
 * @description: 工作人员登录控制
 * @author: Steven Yang
 * @create: 2019-10-15 13:54
 **/
public class WorkerLogin {

    /**
     * @description: 登录
     * @params: 登录信息
     * @return: 是否登录成功
     * @author: StevenYang
     * @create: 2019/10/15
     */
    public boolean login(WorkerLoginModel lm) {
        //根据工作人员编号去获取工作人员的信息
        UserModel worker = findWorkerByWorkerId(lm.getWorkerId());
        //判断前台传递过来的用户名和加密后的密码数据
        if (worker != null) {
            String encryptPwd = this.encryptPwd(lm.getPwd());
            if (worker.getUserId().equals(lm.getWorkerId())
                    && worker.getPwd().equals(encryptPwd)) {
                return true;
            }
        }
        return false;
    }

    private String encryptPwd(String pwd) {
        return pwd;
    }

    private UserModel findWorkerByWorkerId(String userId) {
        UserModel userModel = new UserModel();
        userModel.setName("worker");
        userModel.setPwd("worker");
        userModel.setUserId(userId);
        userModel.setUuid("worker001");
        return userModel;
    }
}
