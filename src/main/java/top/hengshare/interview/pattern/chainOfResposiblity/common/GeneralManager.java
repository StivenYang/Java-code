package top.hengshare.interview.pattern.chainOfResposiblity.common;

/**
 * @program: Java-Interview
 * @description: ProjectManager
 * @author: StivenYang
 * @create: 2019-11-01 15:13
 **/
public class GeneralManager extends Handler {

	@Override
	public Object handleRequest(RequestModel requestModel) {
		if (FeeRequestModel.FEE_TYPE.equals(requestModel.getType())) {
			//聚餐费用申请
			return handleFeeRequest(requestModel);
		} else {
			//其他的项目经理暂时不进行处理
			return super.handleRequest(requestModel);
		}
	}

	private Object handleFeeRequest(RequestModel requestModel) {
		FeeRequestModel frm = (FeeRequestModel) requestModel;
		String str = "";
		if (frm.getFee() >= 1000) {
			if ("小李".equals(frm.getUser())) {
				str = "总经理同意" + frm.getUser() + "聚餐费用" + frm.getFee() + "元的请求";
			} else {
				str = "总经理不同意" + frm.getUser() + "聚餐费用" + frm.getFee() + "元的请求";
			}
		} else {
			if (this.successor != null) {
				return successor.handleRequest(requestModel);
			}
		}
		return str;
	}
}
