package top.hengshare.interview.pattern.proxy.simpleProxy;

public class Client {
    public static void main(String[] args) {
        OrderProxy orderProxy = new OrderProxy("代理模式", 100, "张三");

        orderProxy.setOrderNum(123, "李四");
        System.out.println(orderProxy);

        orderProxy.setOrderNum(234, "张三");
        System.out.println(orderProxy);

    }
}
