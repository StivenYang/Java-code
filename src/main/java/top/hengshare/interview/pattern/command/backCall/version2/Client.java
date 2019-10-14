package top.hengshare.interview.pattern.command.backCall.version2;

public class Client {
    public static void main(String[] args) {
        Command printService = new PrintService("退化命令模式1");

        Invoker invoker = new Invoker();
        invoker.startPrint(printService);
    }
}
