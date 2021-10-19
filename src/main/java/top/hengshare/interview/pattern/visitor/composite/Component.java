package top.hengshare.interview.pattern.visitor.composite;

/**
 * @program: Java-Interview
 * @description: Component
 * @author: StivenYang
 * @create: 2019-11-05 16:09
 **/
public abstract class Component {

	public abstract void accept(Visitor visitor);

	public void addChild(Component child) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}

	public void removeChild(Component child) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}

	public Component getChildren(int index) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}
}
