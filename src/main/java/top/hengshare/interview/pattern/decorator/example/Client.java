package top.hengshare.interview.pattern.decorator.example;

/**
 * @program: Java-Interview
 * @description: Client
 * @author: StivenYang
 * @create: 2019-10-31 15:23
 **/
public class Client {
	public static void main(String[] args) {
		//先创建奖金的对象
		Prize prize = new Prize();
		//日期对象没有用上，所以传null就可以了
		double zs = prize.calcPrize("张三", null, null);
		System.out.println("张三应得奖金：" + zs);
		double ls = prize.calcPrize("李四", null, null);
		System.out.println("李四应得奖金：" + ls);
		double ww = prize.calcPrize("王五", null, null);
		System.out.println("王五应得奖金：" + ww);
	}
}