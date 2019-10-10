package top.hengshare.interview.pattern.prototype.example;

public class Client {
    public static void main(String[] args) {
        //创建订单对象
        PersonalOrder order = new PersonalOrder();
        //设置订单数据
        order.setProductId("P0002");
        order.setOrderProductNum(2185);
        order.setCustomerName("李四");
        //获取业务处理的类
        OrderBussiness orderBussiness = new OrderBussiness();
        //对订单进行业务处理
        orderBussiness.saveOrder(order);
    }
}
