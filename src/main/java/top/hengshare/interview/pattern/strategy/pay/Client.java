package top.hengshare.interview.pattern.strategy.pay;

import top.hengshare.interview.pattern.strategy.struct.Context;

/**
 * @program: Java-Interview
 * @description: 测试工资发放格式的策略
 * @author: Steven Yang
 * @create: 2019-10-16 09:46
 **/
public class Client {
    public static void main(String[] args) {
        /**************策略模式测试*******************/
        //创建相应的支付策略
        RMBCash rmbCash = new RMBCash();
        DollarCash dollarCash = new DollarCash();

        //创建上下文
        PaymentContext context = new PaymentContext("张三", 5000, rmbCash);
        //向张三支付工资
        context.payNow();

        //切换一个人，给另外一个李四发放工资
        PaymentContext context1 = new PaymentContext("李四", 5000, dollarCash);
        context1.payNow();

        /************策略模式扩展，扩展上下文进行扩展*******************/
        //给王五工资卡发放工资
        Card card = new Card();
        PaymentContext2 context2 = new PaymentContext2("王五", 5000, "01010010", card);
        context2.payNow();

        /*************策略模式扩展，策略算法传参进行扩展*************************/
        Card2 card2 = new Card2("010000100");
        new PaymentContext("赵六", 5000, card2).payNow();
    }
}
