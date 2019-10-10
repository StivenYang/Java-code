package top.hengshare.interview.pattern.prototype.deepClone;

/**
 * 订单的接口
 */
public interface OrderAPI {
    /**
     * 获取订单产品数量
     * @return
     */
    int getOrderProductNum();

    /**
     * 设置订单产品数量
     * @param num
     */
    void setOrderProductNum(int num);

    OrderAPI cloneOrder();
}
