package top.hengshare.interview.pattern.facade;

public class Facade {
    private AModule aModule = new AModule();
    private BModule bModule = new BModule();

    public void test() {
        aModule.testA();
        bModule.testB();
        System.out.println("任务完成！");
    }
}
