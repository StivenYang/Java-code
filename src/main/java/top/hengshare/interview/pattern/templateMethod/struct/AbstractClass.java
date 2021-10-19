package top.hengshare.interview.pattern.templateMethod.struct;

/**
 * @program: Java-Interview
 * @description: 模板方法
 * @author: Steven Yang
 * @create: 2019-10-15 14:05
 **/
public abstract class AbstractClass {

	/**
	 * 原语操作1 ：即必须由子类实现的方法，抽象方法
	 */
	public abstract void doPrimitiveOperation1();

	/**
	 * 原语操作2
	 */
	public abstract void doPrimitiveOperation2();

	/**
	 * 模板方法，即算法骨架，这部分是不变的1
	 */
	public final void templateMethod() {
		doPrimitiveOperation1();
		doPrimitiveOperation2();
	}
}
