package top.hengshare.interview.pattern.prototype.deepCloneOnJava;

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
    protected Object clone() {
        PersonalOrder obj = null;
        try {
            obj = (PersonalOrder) super.clone();
            //todo 不可以缺少这句话,如果少了这句话，克隆出来的对象会影响原来对象中的原product成员
            obj.setProduct((Product) this.product.clone());
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return obj;
    }
}
