package top.hengshare.interview.pattern.decorator.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: Java-Interview
 * @description: LogDecorator
 * @author: StivenYang
 * @create: 2019-10-31 20:17
 **/
public class LogDecorator extends Decorator {
    public LogDecorator(GoodsSaleEbi ebi) {
        super(ebi);
    }

    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        //执行业务功能
        boolean f = this.ebi.sale(user, customer, saleModel);

        //执行人物之后记录日志
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println("日志记录：" + user + "于" + sdf.format(new Date()) + "时" +
                "保存了一条销售记录，客户是：" + customer + ", 购买记录是" + saleModel);
        return f;
    }
}
