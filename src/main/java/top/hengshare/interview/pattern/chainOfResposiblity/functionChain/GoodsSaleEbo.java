package top.hengshare.interview.pattern.chainOfResposiblity.functionChain;

import top.hengshare.interview.pattern.decorator.aop.SaleModel;

/**
 * @program: Java-Interview
 * @description: 商品销售管理模块的业务处理
 * @author: StivenYang
 * @create: 2019-11-01 16:31
 **/
public class GoodsSaleEbo {
    public boolean sale(String user, String customer, SaleModel saleModel){
        //如果全部业务都在这里，基本的顺序是：
        //1. 权限检查
        //2. 通用数据检查
        //3. 数据逻辑校验
        //4. 真正的业务处理

        //但是现在通过功能链来做，这里主要负责构建链
        SaleSecurityCheck securityCheck = new SaleSecurityCheck();
        SaleDataCheck dataCheck = new SaleDataCheck();
        SaleLogicCheck logicCheck = new SaleLogicCheck();
        SaleMgr mgr = new SaleMgr();
        securityCheck.setSuccessor(dataCheck);
        dataCheck.setSuccessor(logicCheck);
        logicCheck.setSuccessor(mgr);

        return securityCheck.sale(user, customer, saleModel);
    }
}
