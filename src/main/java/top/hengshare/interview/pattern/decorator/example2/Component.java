package top.hengshare.interview.pattern.decorator.example2;

import java.util.Date;

/**
 * @program: Java-Interview
 * @description: PrizeComponent
 * @author: StivenYang
 * @create: 2019-10-31 15:46
 **/
public abstract class Component {

    /**
     * 计算奖金的方法
     * @param user
     * @param begin
     * @param end
     * @return
     */
    public abstract double calcPrize(String user, Date begin, Date end);
}
