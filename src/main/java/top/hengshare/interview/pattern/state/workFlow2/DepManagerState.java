package top.hengshare.interview.pattern.state.workFlow2;

import java.util.Scanner;

/**
 * @program: Java-Interview
 * @description:
 * @author: Steven Yang
 * @create: 2019-10-17 21:42
 **/
public class DepManagerState implements LeaveRequestState {
    @Override
    public void doWork(StateMachine request) {
        //1. 还原业务数据
        LeaveRequestModel lrm = (LeaveRequestModel) request.getBusinessVO();

        System.out.println("部门经理审核中，请稍后。。。");
        //2. 把审核结果保存到数据库中

        //3. 部门经理进行审批，无论是否通过，都转到了审批结束
        System.out.println(lrm.getUser() + "申请从" + lrm.getBeginDate()
                + "开始请假" + lrm.getLeaveDays() +
                "天，请部门经理进行审核(1.同意  2.不同意)");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int i = scanner.nextInt();
            String result = "不同意";
            if (i == 1) {
                result = "同意";
            }
            lrm.setResult("部门经理审核结果：" + result);
            //部门经理审核过后，直接进入结束状态
            request.setState(new auditOverState());
            //4. 给申请人新增一条任务，查看审批结果
            request.doWork();
        }
    }
}
