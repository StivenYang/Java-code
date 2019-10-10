package top.hengshare.interview.pattern.prototype.example;

import lombok.Data;

/**
 * 企业订单对象
 */
@Data
public class EnterpriseOrder implements OrderAPI {

    /**
     * 企业名称
     */
    private String enterpriseName;
    /**
     * 产品id
     */
    private String productId;
    /**
     * 订单产品数量
     */
    private int orderProductNum = 0;

    @Override
    public int getOrderProductNum() {
        return this.orderProductNum;
    }

    @Override
    public void setOrderProductNum(int num) {
        this.orderProductNum = num;
    }

    @Override
    public OrderAPI cloneOrder() {
        EnterpriseOrder order = new EnterpriseOrder();
        order.setEnterpriseName(this.enterpriseName);
        order.setOrderProductNum(this.orderProductNum);
        order.setProductId(this.productId);
        return order;
    }
}
