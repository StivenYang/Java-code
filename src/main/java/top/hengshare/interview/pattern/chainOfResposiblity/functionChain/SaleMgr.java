package top.hengshare.interview.pattern.chainOfResposiblity.functionChain;

import top.hengshare.interview.pattern.decorator.aop.SaleModel;

/**
 * @program: Java-Interview
 * @description: SaleMgr
 * @author: StivenYang
 * @create: 2019-11-01 16:46
 **/
public class SaleMgr extends SaleHandler {
    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        System.out.println(user + "保存了" + customer + "购买" + saleModel + "的销售数据");
        return true;
    }
}
