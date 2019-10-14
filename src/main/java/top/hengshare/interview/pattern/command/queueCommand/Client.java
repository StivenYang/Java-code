package top.hengshare.interview.pattern.command.queueCommand;

public class Client {
    public static void main(String[] args) {
        CookManager.runCookManager();

        for (int i=0; i<5; i++){
            //服务员过来了
            Waiter waiter = new Waiter();
            //客户点菜
            waiter.orderDish(new ChopCommand(i+1));
            ChopCommand chopCommand = new ChopCommand(1);
            //点菜完毕
            waiter.orderDish(chopCommand);
            waiter.orderOver();
        }
    }
}
