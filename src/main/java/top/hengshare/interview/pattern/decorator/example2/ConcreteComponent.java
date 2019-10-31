package top.hengshare.interview.pattern.decorator.example2;

import java.util.Date;

/**
 * @program: Java-Interview
 * @description: ConcreteComponent
 * @author: StivenYang
 * @create: 2019-10-31 15:48
 **/
public class ConcreteComponent extends Component {
    @Override
    public double calcPrize(String user, Date begin, Date end) {
        //只是一个默认的实现，默认没有奖金
        return 0;
    }
}
