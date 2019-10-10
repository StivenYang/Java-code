package top.hengshare.interview.pattern.prototype.javaClone;

import lombok.Data;

@Data
public class PersonalOrder implements Cloneable, OrderAPI {

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
    private int orderProductNum;

    @Override
    public int getOrderProductNum() {
        return this.orderProductNum;
    }

//    @Override
//    public void setOrderProductNum(int num) {
//        this.orderProductNum = num;
//    }
//
//    @Override
//    public OrderAPI cloneOrder() {
//        PersonalOrder order = new PersonalOrder();
//        order.setCustomerName(this.customerName);
//        order.setOrderProductNum(this.orderProductNum);
//        order.setProductId(this.productId);
//        return order;
//    }
    public Object clone(){
        //直接调用父类的克隆方法就行
        Object obj = null;
        try {
            obj = super.clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
