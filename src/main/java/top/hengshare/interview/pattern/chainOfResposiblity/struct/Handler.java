package top.hengshare.interview.pattern.chainOfResposiblity.struct;

import lombok.Setter;

/**
 * @program: Java-Interview
 * @description: Handler
 * @author: StivenYang
 * @create: 2019-11-01 08:51
 **/
public abstract class Handler {

	@Setter
	protected Handler successor;

	/**
	 * 示意处理请求的方法，虽然这个示意方法是没有传入参数的
	 * 但实际是可以传入参数的，根据具体需要来选择是否传递参数
	 */
	public abstract void handleRequest();
}
