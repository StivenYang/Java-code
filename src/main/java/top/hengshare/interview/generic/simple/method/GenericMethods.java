package top.hengshare.interview.generic.simple.method;

/**
 * @program: Java-Interview
 * @description: 泛型方法
 * @author: StivenYang
 * @create: 2019-11-17 15:42
 **/
public class GenericMethods {
	public <T> void f(T x) {
		System.out.println(x.getClass().getName());
	}

	public static void main(String[] args) {
		GenericMethods gm = new GenericMethods();
		gm.f("");
		gm.f(1);
		gm.f(1.0);
		gm.f(1.0F);
		gm.f('c');
		gm.f(gm);
	}
}
