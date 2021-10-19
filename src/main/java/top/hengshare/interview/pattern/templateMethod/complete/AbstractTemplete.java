package top.hengshare.interview.pattern.templateMethod.complete;

/**
 * @program: Java-Interview
 * @description: 较为完整的模板定义实例
 * @author: Steven Yang
 * @create: 2019-10-15 17:10
 **/
public abstract class AbstractTemplete {

	/**
	 * @description: 模板算法，定义算法骨架
	 * @params: []
	 * @return: void
	 * @author: StevenYang
	 * @create: 2019/10/15
	 */
	public final void templateMethod() {
		//第一步
		this.operation1();
		//第二部
		this.operation2();
		//第三部
		this.doPrimitiveOperation1();
		//第四部
		this.doPrimitiveOperation2();
		//第五部
		this.hookOperation1();
	}

	protected void hookOperation1() {
	}

	protected abstract void doPrimitiveOperation2();

	protected abstract void doPrimitiveOperation1();

	/**
	 * @description: 算法中的步骤，final修饰，固定算法，子类不可以重写
	 * @params: []
	 * @return: void
	 * @author: StevenYang
	 * @create: 2019/10/15
	 */
	private final void operation2() {
	}

	/**
	 * @description: 算法中的步骤，固定实现，且子类不需要访问，private修饰
	 * @params: []
	 * @return: void
	 * @author: StevenYang
	 * @create: 2019/10/15
	 */
	private void operation1() {
	}

	/**
	 * @description: 具体的AbstractClass操作，子类的公共功能，可以重写，通常不是算法的步骤
	 * @params: []
	 * @return: void
	 * @author: StevenYang
	 * @create: 2019/10/15
	 */
	protected void commonOperation() {
	}

	/**
	 * @description: 工厂方法，创建某个对象，这里用Object代替了，在算法实现中可能需要
	 * @params: []
	 * @return: 某个对象
	 * @author: StevenYang
	 * @create: 2019/10/15
	 */
	protected abstract Object getOneObject();
}
