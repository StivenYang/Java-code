package top.hengshare.interview.pattern.state.workFlow2;

import java.util.Scanner;

/**
 * @program: Java-Interview
 * @description: 项目经理审核状态
 * @author: Steven Yang
 * @create: 2019-10-17 21:33
 **/
public class ProjectManagerState implements LeaveRequestState {
    @Override
    public void doWork(StateMachine request) {
        //1. 先把业务对象造型出来
        LeaveRequestModel lrm = (LeaveRequestModel)request.getBusinessVO();

        //2. 把审核结果保存到数据库中

        //3. 根据选择的结果和条件来设置下一步
        System.out.println("项目经理正在审核中，请稍后。。。");
        //模拟用户处理界面
        System.out.println(lrm.getUser() + "申请从" + lrm.getBeginDate() + "开始请假" + lrm.getLeaveDays() +
                "天，请项目经理进行审核(1.同意  2.不同意)");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int a = scanner.nextInt();
            String result = "不同意";
            if (a == 1) {
                result = "同意";
            }
            lrm.setResult("项目经理审核结果是：" + result);

            if (a == 1) {
                if (lrm.getLeaveDays() > 3) {
                    //如果请假天数大于三天，且项目经理同意了，那么提交给部门经理审批
                    request.setState(new DepManagerState());
                    //为部门经理增加一个审批任务
                    request.doWork();
                }else {
                    //3天以内的请假，由项目经理做主，转到审批结束状态
                    request.setState(new auditOverState());
                    //给申请人增加一个任务，让他可以看见审核结果
                    request.doWork();
                }
            }else {
                //项目经理不同意
                request.setState(new auditOverState());
                //给申请人增加一个任务，让他可以看见审核结果
                request.doWork();
            }
        }


    }
}
