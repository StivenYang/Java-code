package top.hengshare.interview.pattern.decorator.example2;

import java.util.Date;

/**
 * @program: Java-Interview
 * @description: SumPrizeDecorator
 * @author: StivenYang
 * @create: 2019-10-31 15:54
 **/
public class SumPrizeDecorator extends Decorator {
    /**
     * 构造装饰器方法
     *
     * @param c
     */
    public SumPrizeDecorator(Component c) {
        super(c);
    }

    @Override
    public double calcPrize(String user, Date begin, Date end) {
        double money = super.calcPrize(user, begin, end);
        //然后计算累计奖金，其实应该按人员获取累计的业务额，然后再乘以0.1%
        double prize = 100000 * 0.001;
        System.out.println(user + "累计奖金" + prize);
        return money + prize;
    }
}
