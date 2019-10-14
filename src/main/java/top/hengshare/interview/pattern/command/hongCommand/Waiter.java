package top.hengshare.interview.pattern.command.hongCommand;

public class Waiter {

    private MenuCommand menuCommand = new MenuCommand();

    public void orderDish(Command cmd){
        //客户传过来的命令对象是没有和接收者组装的，也就是说，客户不知道这个菜是哪个厨师来做
        //所以在这里需要针对不同的菜品，来设置不同的厨师来做
        HotCook hotCook = new HotCook();
        CoolCook coolCook = new CoolCook();

        //如果点的是绿豆排骨煲，那么应该是热菜厨师做
        if (cmd instanceof ChopCommand) {
            ((ChopCommand)cmd).setCookAPI(hotCook);
        }

        //向服务员的宏命令中添加命令，也就是点菜
        menuCommand.addCommand(cmd);
    }

    public void setMenuCommand(MenuCommand menuCommand) {
        this.menuCommand = menuCommand;
    }

    /**
     * 点完菜了，交给后厨做菜
     */
    public void orderOver(){
        this.menuCommand.execute();
    }
}
