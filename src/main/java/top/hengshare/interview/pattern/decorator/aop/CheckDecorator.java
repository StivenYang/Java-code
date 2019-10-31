package top.hengshare.interview.pattern.decorator.aop;

/**
 * @program: Java-Interview
 * @description: CheckDecorator
 * @author: StivenYang
 * @create: 2019-10-31 20:14
 **/
public class CheckDecorator extends Decorator {
    public CheckDecorator(GoodsSaleEbi ebi) {
        super(ebi);
    }

    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        if (!"张三".equals(user)) {
            System.out.println("地不起" + user + "没有保存销售单的权限");
            return false;
        }else {
            return this.ebi.sale(user, customer, saleModel);
        }
    }
}
