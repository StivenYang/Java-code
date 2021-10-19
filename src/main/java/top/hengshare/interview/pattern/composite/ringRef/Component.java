package top.hengshare.interview.pattern.composite.ringRef;

/**
 * 抽象的组件对象
 */
public abstract class Component {
	private String componentPath = "";

	public abstract String getName();

	public abstract void printStruct(String preStr);

	public void addChild(Component component) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}

	public void removeChild(Component component) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}

	public Component getChildren(int index) {
		throw new UnsupportedOperationException("对象不支持这个功能");
	}

	public String getComponentPath() {
		return componentPath;
	}

	public void setComponentPath(String componentPath) {
		this.componentPath = componentPath;
	}
}
