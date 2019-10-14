package top.hengshare.interview.pattern.command.backCall.version1;

public class PrintService implements Command {
    private String str = "";

    public PrintService(String str) {
        this.str = str;
    }

    @Override
    public void execute() {
        System.out.println("打印：" + str);
    }
}
