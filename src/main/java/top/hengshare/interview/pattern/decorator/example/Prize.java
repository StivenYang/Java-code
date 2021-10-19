package top.hengshare.interview.pattern.decorator.example;

import java.util.Date;

/**
 * @program: Java-Interview
 * @description: Prize
 * @author: StivenYang
 * @create: 2019-10-31 15:07
 **/
public class Prize {
	public double calcPrize(String user, Date begin, Date end) {
		double prize = 0.0;
		//计算当月业务奖金，所有人都会计算
		prize = this.monthPrize(user, begin, end);
		//计算累计奖金
		prize += this.sumPrize(user, begin, end);

		//需要判断该人员是普通人员还是业务经理，团队奖金只有业务经理才有
		if (this.isManager(user)) {
			prize += this.groupPrize(user, begin, end);
		}
		return prize;
	}

	private double monthPrize(String user, Date begin, Date end) {
		//计算当月业务奖金，按照人员去获取当月的业务额，然后再乘以3%
		double prize = TempDB.mapMonthSaleMoney.get(user) * 0.3;
		System.out.println(user + "当月业务奖金：" + prize);
		return prize;
	}

	private double sumPrize(String user, Date begin, Date end) {
		//计算某人的累计奖金，其实应该按照人员去获取累计的业务额度，然后再乘以0.1%
		//假定大家的累计业务额度都是100000元
		double prize = 100000 * 0.001;
		System.out.println(user + "累计奖金：" + prize);
		return prize;
	}

	private boolean isManager(String user) {
		//假定只有王五是业务经理
		if ("王五".equals(user)) {
			return true;
		}
		return false;
	}

	public double groupPrize(String user, Date begin, Date end) {
		//计算当月团队业务奖金，先计算出团队总的业务额，然后再乘以1%
		double group = 0.0;
		for (Double s : TempDB.mapMonthSaleMoney.values()) {
			group += s;
		}
		double prize = group * 0.01;
		System.out.println(user + "当月团队业务奖金：" + prize);
		return prize;
	}
}
