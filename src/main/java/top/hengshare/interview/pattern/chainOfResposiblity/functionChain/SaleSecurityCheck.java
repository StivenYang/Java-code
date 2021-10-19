package top.hengshare.interview.pattern.chainOfResposiblity.functionChain;

import top.hengshare.interview.pattern.decorator.aop.SaleModel;

/**
 * @program: Java-Interview
 * @description: SaleSecurityCheck
 * @author: StivenYang
 * @create: 2019-11-01 16:38
 **/
public class SaleSecurityCheck extends SaleHandler {
	@Override
	public boolean sale(String user, String customer, SaleModel saleModel) {
		//进行权限检查，简单点，就小李可以通过
		if ("小李".equals(user)) {
			return this.successor.sale(user, customer, saleModel);
		} else {
			System.out.println("对不起" + user + ",你没有权限保存销售记录的权限");
			return false;
		}
	}
}
