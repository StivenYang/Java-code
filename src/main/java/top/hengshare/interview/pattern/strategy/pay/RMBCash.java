package top.hengshare.interview.pattern.strategy.pay;

/**
 * @program: Java-Interview
 * @description: 人民币支付
 * @author: Steven Yang
 * @create: 2019-10-16 09:44
 **/
public class RMBCash implements PaymentStrategy {
    @Override
    public void pay(PaymentContext ctx) {
        System.out.println("现在给：" + ctx.getUsername() + "发放：" + ctx.getMoney() + "元");
    }
}
