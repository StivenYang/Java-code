package top.hengshare.interview.pattern.chainOfResposiblity.functionChain;

import org.apache.commons.lang3.StringUtils;
import top.hengshare.interview.pattern.decorator.aop.SaleModel;

/**
 * @program: Java-Interview
 * @description: 进行数据通用检查的职责对象
 * @author: StivenYang
 * @create: 2019-11-01 16:39
 **/
public class SaleDataCheck extends SaleHandler {

    @Override
    public boolean sale(String user, String customer, SaleModel saleModel) {
        //进行数据检查，麻烦点，对每个数据都进行检查
        if (StringUtils.isEmpty(user)) {
            System.out.println("申请人不能为空");
            return false;
        }
        if (StringUtils.isEmpty(customer)) {
            System.out.println("客户不能为空");
            return false;
        }
        if (saleModel == null) {
            System.out.println("销售的商品不能为空");
            return false;
        }
        if (StringUtils.isEmpty(saleModel.getGoods())) {
            System.out.println("商品名称不能为空");
            return false;
        }
        if (saleModel.getSaleNum() == 0) {
            System.out.println("销售商品的数据量不能为0");
            return false;
        }
        //校验通过，继续后续的步骤
        return this.successor.sale(user, customer, saleModel);
    }
}
