package top.hengshare.interview.pattern.composite.struct;

import com.google.common.collect.Lists;

import java.util.List;

public class Composite extends Component {

	private List<Component> childComponents;

	@Override
	public void someOperation() {
		if (childComponents != null) {
			for (Component component : childComponents) {
				component.someOperation();
			}
		}
	}

	@Override
	public void addChild(Component component) {
		if (childComponents == null) {
			childComponents = Lists.newArrayList();
		}
		childComponents.add(component);
	}

	@Override
	public void removeChild(Component component) {
		if (childComponents != null) {
			childComponents.remove(component);
		}
	}

	@Override
	public Component getChildren(int index) {
		if (childComponents != null) {
			if (index > 0 && index < childComponents.size()) {
				return childComponents.get(index);
			}
		}
		return null;
	}
}
