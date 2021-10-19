package top.hengshare.interview.pattern.decorator.aop;

/**
 * @program: Java-Interview
 * @description: Client
 * @author: StivenYang
 * @create: 2019-10-31 20:20
 **/
public class Client {
	public static void main(String[] args) {
		//得到业务接口
		CheckDecorator decorator = new CheckDecorator(new LogDecorator(new GoodsSaleEbo()));
		//准备测试数据
		SaleModel saleModel = new SaleModel();
		saleModel.setGoods("Moto 手机");
		saleModel.setSaleNum(2);

		//调用业务功能
		decorator.sale("张三", "张三丰", saleModel);
		decorator.sale("李四", "张三丰", saleModel);
	}
}
