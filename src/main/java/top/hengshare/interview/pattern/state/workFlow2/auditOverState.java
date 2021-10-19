package top.hengshare.interview.pattern.state.workFlow2;

/**
 * @program: Java-Interview
 * @description:
 * @author: Steven Yang
 * @create: 2019-10-17 21:46
 **/
public class auditOverState implements LeaveRequestState {
	@Override
	public void doWork(StateMachine request) {
		//审批结束
		//1. 获取审批结果
		LeaveRequestModel lrm = (LeaveRequestModel) request.getBusinessVO();
		//2. 保存结果到数据库
		//3. 业务处理，结束整个流程
		System.out.println(lrm.getUser() + "，你的请假申请已经审核完毕，结果是：" + lrm.getResult());
	}
}
