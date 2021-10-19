package top.hengshare.interview.pattern.chainOfResposiblity.functionChain;

import lombok.Setter;
import top.hengshare.interview.pattern.decorator.aop.SaleModel;

/**
 * @program: Java-Interview
 * @description: 定义职责对象的接口
 * @author: StivenYang
 * @create: 2019-11-01 16:35
 **/
public abstract class SaleHandler {
	/**
	 * 持有下一个处理请求的对象
	 */
	@Setter
	protected SaleHandler successor;

	/**
	 * 销售的接口
	 * @param user
	 * @param customer
	 * @return
	 */
	public abstract boolean sale(String user, String customer, SaleModel saleModel);
}
