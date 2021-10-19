package top.hengshare.interview.pattern.chainOfResposiblity.example2;

/**
 * @program: Java-Interview
 * @description: ProjectManager
 * @author: StivenYang
 * @create: 2019-11-01 09:06
 **/
public class ProjectManager extends Handler {
	@Override
	public String handleFeeRequest(String user, double fee) {
		String str = "";

		if (fee < 500) {
			if ("小李".equals(user)) {
				str = "项目经理同意" + user + "的" + fee + "的聚餐费用";
			} else {
				str = "项目经理不同意" + user + "的" + fee + "的聚餐费用";

			}
		} else {
			if (this.successor != null) {
				return successor.handleFeeRequest(user, fee);
			}
		}

		return str;
	}

	@Override
	public boolean handlePreRequest(String user, double fee) {
		if (fee < 5000) {
			System.out.println("项目经理同意" + user + "的" + fee + "的费用");
			return true;
		} else {
			if (this.successor != null) {
				return this.successor.handlePreRequest(user, fee);
			}
		}
		return false;
	}
}
