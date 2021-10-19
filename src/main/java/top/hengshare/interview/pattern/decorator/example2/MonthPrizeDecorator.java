package top.hengshare.interview.pattern.decorator.example2;

import top.hengshare.interview.pattern.decorator.example.TempDB;

import java.util.Date;

/**
 * @program: Java-Interview
 * @description: MonthPrizeDecorator
 * @author: StivenYang
 * @create: 2019-10-31 15:51
 **/
public class MonthPrizeDecorator extends Decorator {
	/**
	 * 构造装饰器方法
	 *
	 * @param c
	 */
	public MonthPrizeDecorator(Component c) {
		super(c);
	}

	@Override
	public double calcPrize(String user, Date begin, Date end) {
		//先获取前面运算得到的奖金
		double money = super.calcPrize(user, begin, end);
		//计算当月业务奖金，按照人员和时间获取当前月业务额，然后乘以3%
		double prize = TempDB.mapMonthSaleMoney.get(user) * 0.03;
		System.out.println(user + "当月业务奖金：" + prize);
		return money + prize;
	}
}
