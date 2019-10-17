package top.hengshare.interview.pattern.state.workFlow2;

/**
 * @program: Java-Interview
 * @description: 测试状态机实现的请假流程
 * @author: Steven Yang
 * @create: 2019-10-17 22:03
 **/
public class Client {
    public static void main(String[] args) {
        //填写请假单
        LeaveRequestModel requestModel = new LeaveRequestModel();
        requestModel.setUser("张三");
        requestModel.setBeginDate("2019年10月17日");
        requestModel.setLeaveDays(6);

        //提交请假单给项目经理
        LeaveRequestContext requestContext = new LeaveRequestContext();
        requestContext.setBusinessVO(requestModel);
        requestContext.setState(new ProjectManagerState());

        //开始请假流程
        requestContext.doWork();
    }
}
