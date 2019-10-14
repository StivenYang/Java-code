package top.hengshare.interview.pattern.command.hongCommand;

public class Client {
    public static void main(String[] args) {
        //一个服务员过来了，她手里拿着一个菜单
        Waiter waiter = new Waiter();
        //我们开始点菜，点了一个绿豆排骨煲
        waiter.orderDish(new ChopCommand());
        //点完交给后厨了
        waiter.orderOver();
    }
}
