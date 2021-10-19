package top.hengshare.interview.pattern.composite.struct;

/**
 * 抽象的组件对象
 */
public abstract class Component {
	public abstract void someOperation();

	public void addChild(Component component) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}

	public void removeChild(Component component) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}

	public Component getChildren(int index) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}
}
