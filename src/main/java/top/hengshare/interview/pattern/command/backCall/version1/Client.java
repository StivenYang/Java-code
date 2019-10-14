package top.hengshare.interview.pattern.command.backCall.version1;

public class Client {
    public static void main(String[] args) {
        Command printService = new PrintService("退化命令模式2");

        Invoker invoker = new Invoker();
        invoker.setCmd(printService);

        invoker.startPrint();
    }
}
