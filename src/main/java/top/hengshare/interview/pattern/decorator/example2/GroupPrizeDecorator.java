package top.hengshare.interview.pattern.decorator.example2;

import top.hengshare.interview.pattern.decorator.example.TempDB;

import java.util.Date;

/**
 * @program: Java-Interview
 * @description: GroupPrizeDecorator
 * @author: StivenYang
 * @create: 2019-10-31 16:12
 **/
public class GroupPrizeDecorator extends Decorator {
	/**
	 * 构造装饰器方法
	 *
	 * @param c
	 */
	public GroupPrizeDecorator(Component c) {
		super(c);
	}

	@Override
	public double calcPrize(String user, Date begin, Date end) {
		double money = super.calcPrize(user, begin, end);
		//计算团队奖金,先计算出团队总的业务额，然后再乘以1%
		double group = 0.0;
		for (Double value : TempDB.mapMonthSaleMoney.values()) {
			group += value;
		}
		double prize = group * 0.01;
		System.out.println(user + "当月团队业务奖金：" + prize);
		return money + prize;
	}
}
