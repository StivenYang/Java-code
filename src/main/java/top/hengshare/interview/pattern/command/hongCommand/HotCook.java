package top.hengshare.interview.pattern.command.hongCommand;

/**
 * 热菜厨师
 */
public class HotCook implements CookAPI {
    @Override
    public void cook(String name) {
        System.out.println("正在做热菜：" + name);
    }
}
