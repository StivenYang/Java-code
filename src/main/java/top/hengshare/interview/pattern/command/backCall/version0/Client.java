package top.hengshare.interview.pattern.command.backCall.version0;

public class Client {
    public static void main(String[] args) {
        //接收者：打印机
        Printer printer = new Printer();
        //具体命令，打印命令
        Command printService = new PrintService(printer);

        //调用者，按打印机的人
        Invoker invoker = new Invoker();
        invoker.setCmd(printService);

        //按下打印按钮
        invoker.startPrint();
    }
}
