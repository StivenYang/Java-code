package top.hengshare.interview.pattern.prototype.deepClone;

import lombok.Data;

@Data
public class PersonalOrder implements OrderAPI {

    /**
     * 顾客姓名
     */
    private String customerName;
    /**
     * 产品id
     */
    private String productId;
    /**
     * 订单产品数量
     */
    private int orderProductNum = 0;
    /**
     * 为了证明深度克隆，新增的引用类型的变量
     */
    private Product product = null;

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
        PersonalOrder order = new PersonalOrder();
        order.setCustomerName(this.customerName);
        order.setOrderProductNum(this.orderProductNum);
        order.setProductId(this.productId);
        //deep clone新增
        order.setProduct((Product) this.product.cloneProduct());
        return order;
    }
}
