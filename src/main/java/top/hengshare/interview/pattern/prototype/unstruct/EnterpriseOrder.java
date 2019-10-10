package top.hengshare.interview.pattern.prototype.unstruct;

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
}
