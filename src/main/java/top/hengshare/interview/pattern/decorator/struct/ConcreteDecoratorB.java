package top.hengshare.interview.pattern.decorator.struct;

/**
 * @program: Java-Interview
 * @description: ConcreteDecoratorB
 * @author: StivenYang
 * @create: 2019-10-31 15:44
 **/
public class ConcreteDecoratorB extends Decorator {
	/**
	 * 构造方法，传入组件对象
	 *
	 * @param component
	 */
	public ConcreteDecoratorB(Component component) {
		super(component);
	}

	@Override
	public void operation() {
		//调用父类的方法
		super.operation();
		//附加方法
		addedBehavior();
	}

	private void addedBehavior() {
		//需要添加的功能
	}
}
