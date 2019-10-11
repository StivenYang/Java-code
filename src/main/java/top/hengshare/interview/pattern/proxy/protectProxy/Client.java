package top.hengshare.interview.pattern.proxy.protectProxy;

public class Client {
    public static void main(String[] args) {
        //张三新建了一个订单
        OrderProxy order = new OrderProxy(new Order("设计模式", 100, "张三"));
        //李四想要修改张三创建的订单数量，会报错，订单的内容不会被改变
        order.setOrderNum(123, "李四");
        System.out.println(order);
        //张三想要修改自己的订单数量
        order.setOrderNum(234, "张三");
        System.out.println(order);
    }
}
