package top.hengshare.interview.pattern.facade;

public class UnPatternClient {
    public static void main(String[] args) {
        AModule aModule = new AModule();
        aModule.testA();
        BModule bModule = new BModule();
        bModule.testB();
        System.out.println("任务完成！");
    }
}
