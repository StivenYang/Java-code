package top.hengshare.interview.pattern.state.workFlow;

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
		LeaveRequestModel lrm = (LeaveRequestModel) request.getBusinessVO();

		//2. 把审核结果保存到数据库中

		//3. 根据选择的结果和条件来设置下一步
		if ("同意".equals(lrm.getResult())) {
			if (lrm.getLeaveDays() > 3) {
				//如果请假天数大于三天，且项目经理同意了，那么提交给部门经理审批
				request.setState(new DepManagerState());
				//为部门经理增加一个审批任务
			} else {
				//3天以内的请假，由项目经理做主，转到审批结束状态
				request.setState(new auditOverState());
				//给申请人增加一个任务，让他可以看见审核结果
			}
		} else {
			//项目经理不同意
			request.setState(new auditOverState());
			//给申请人增加一个任务，让他可以看见审核结果
		}

	}
}
