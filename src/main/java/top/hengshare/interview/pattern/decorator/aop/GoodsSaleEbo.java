package top.hengshare.interview.pattern.decorator.aop;

/**
 * @program: Java-Interview
 * @description: GoodsSaleEbo
 * @author: StivenYang
 * @create: 2019-10-31 20:09
 **/
public class GoodsSaleEbo implements GoodsSaleEbi {

	@Override
	public boolean sale(String user, String customer, SaleModel saleModel) {
		System.out.println(user + "保存了" + customer + "购买" + saleModel + "的销售数据");
		return true;
	}
}
