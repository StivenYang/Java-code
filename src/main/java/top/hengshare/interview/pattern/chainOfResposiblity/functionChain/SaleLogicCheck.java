package top.hengshare.interview.pattern.chainOfResposiblity.functionChain;

import top.hengshare.interview.pattern.decorator.aop.SaleModel;

/**
 * @program: Java-Interview
 * @description: SaleLogicCheck
 * @author: StivenYang
 * @create: 2019-11-01 16:44
 **/
public class SaleLogicCheck extends SaleHandler {
	@Override
	public boolean sale(String user, String customer, SaleModel saleModel) {
		//进行数据的逻辑教研，比如检查id唯一性，主键对外关系等
		//为了演示简单，直接放行

		return this.successor.sale(user, customer, saleModel);
	}
}
