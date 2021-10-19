package top.hengshare.interview.pattern.state.workFlow;

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

		//2. 把审核结果保存到数据库中

		//3. 部门经理进行审批，无论是否通过，都转到了审批结束
		request.setState(new auditOverState());
		//4. 给申请人新增一条任务，查看审批结果
	}
}
