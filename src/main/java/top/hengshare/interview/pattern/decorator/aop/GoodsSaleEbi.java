package top.hengshare.interview.pattern.decorator.aop;

/**
 * @program: Java-Interview
 * @description: 商品销售管理的业务接口
 * @author: StivenYang
 * @create: 2019-10-31 20:05
 **/
public interface GoodsSaleEbi {

	boolean sale(String user, String customer, SaleModel saleModel);
}
