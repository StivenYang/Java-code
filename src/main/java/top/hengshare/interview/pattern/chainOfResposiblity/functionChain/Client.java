package top.hengshare.interview.pattern.chainOfResposiblity.functionChain;

import top.hengshare.interview.pattern.decorator.aop.SaleModel;

/**
 * @program: Java-Interview
 * @description: Client
 * @author: StivenYang
 * @create: 2019-11-01 16:50
 **/
public class Client {
	public static void main(String[] args) {
		//创建业务对象
		GoodsSaleEbo saleEbo = new GoodsSaleEbo();
		//准备测试数据
		SaleModel saleModel = new SaleModel();
		saleModel.setSaleNum(3);
		saleModel.setGoods("张学友怀旧经典");

		saleEbo.sale("小李", "张三", saleModel);
		saleEbo.sale("小张", "李四", saleModel);
	}
}
