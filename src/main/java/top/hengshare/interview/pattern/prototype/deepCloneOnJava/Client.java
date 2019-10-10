package top.hengshare.interview.pattern.prototype.deepCloneOnJava;

public class Client {
    public static void main(String[] args) {
        //创建订单对象
        PersonalOrder order = new PersonalOrder();
        Product product = new Product();
        product.setProductId("01");
        product.setName("产品1");
        //设置订单数据
        order.setProduct(product);
        order.setProductId("P0002");
        order.setOrderProductNum(2185);
        order.setCustomerName("李四");

        System.out.println("这是第一次获取的对象实例==" + order);

        //深度克隆order对象
        PersonalOrder order1 = (PersonalOrder) order.clone();
        order1.setCustomerName("张三");
        order1.setOrderProductNum(90);
        order1.getProduct().setName("产品2");
        order1.getProduct().setProductId("02");
        System.out.println("这是输出克隆之后的对象实例==" + order1);

        System.out.println("原来的实例==" + order);
    }
}
