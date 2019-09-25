package top.hengshare.interview.pattern.facade;

public class AModule implements AModuleApi {
    @Override
    public void testA() {
        System.out.println("调用a模块(1/2)");
    }
}
