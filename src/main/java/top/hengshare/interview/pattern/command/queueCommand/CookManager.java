package top.hengshare.interview.pattern.command.queueCommand;

public class CookManager {

    private static boolean runFlag = false;

    public static void runCookManager(){
        if (!runFlag) {
            runFlag = true;

            HotCook 张三 = new HotCook("张三");
            HotCook 李四 = new HotCook("李四");
            HotCook 王五 = new HotCook("王五");

            new Thread(张三).start();
            new Thread(李四).start();
            new Thread(王五).start();
        }
    }
}
