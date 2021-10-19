package top.hengshare.interview.pattern.chainOfResposiblity.common;

import lombok.Setter;

/**
 * @program: Java-Interview
 * @description: Handler
 * @author: StivenYang
 * @create: 2019-11-01 11:56
 **/
public abstract class Handler {

	@Setter
	protected Handler successor;

	public Object handleRequest(RequestModel requestModel) {
		if (successor != null) {
			return this.successor.handleRequest(requestModel);
		} else {
			System.out.println("没有后续处理，或者暂时不支持这样的功能");
			return false;
		}
	}
}
