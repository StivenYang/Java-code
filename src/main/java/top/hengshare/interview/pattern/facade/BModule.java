package top.hengshare.interview.pattern.facade;

public class BModule implements BModuleApi {
	@Override
	public void testB() {
		System.out.println("调用B模块(2/2)");
	}
}
