package top.hengshare.interview.pattern.decorator.example2;

/**
 * @program: Java-Interview
 * @description: Client
 * @author: StivenYang
 * @create: 2019-10-31 16:15
 **/
public class Client {
	public static void main(String[] args) {
		//先创建计算基本奖金的类，这也是被装饰的对象
		ConcreteComponent concreteComponent = new ConcreteComponent();

		//然后对计算的基本奖金进行装饰，这里要组合各个装饰
		//说明：各个装饰者之间最好是不要有先后顺序的限制
		//也就是先装饰谁和后装饰谁都应该是一样的

		//先组合普通业务人员的奖金计算
		MonthPrizeDecorator monthPrizeDecorator = new MonthPrizeDecorator(concreteComponent);
		SumPrizeDecorator sumPrizeDecorator = new SumPrizeDecorator(monthPrizeDecorator);

		//注意：只需要使用最后装饰好的对象调用业务方法即可，会依次调用回去
		double zs = sumPrizeDecorator.calcPrize("张三", null, null);
		System.out.println("=======张三应得奖金：" + zs);
		double ls = sumPrizeDecorator.calcPrize("李四", null, null);
		System.out.println("=======李四应得奖金：" + ls);

		//还有个业务经理，所以需要再装饰一下
		GroupPrizeDecorator groupPrizeDecorator = new GroupPrizeDecorator(sumPrizeDecorator);
		double ww = groupPrizeDecorator.calcPrize("王五", null, null);
		System.out.println("=======王五应得奖金：" + ww);
	}
}
