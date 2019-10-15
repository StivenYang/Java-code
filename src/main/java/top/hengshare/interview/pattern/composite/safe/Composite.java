package top.hengshare.interview.pattern.composite.safe;

import com.google.common.collect.Lists;

import java.util.List;

public class Composite extends Component {

    private List<Component> childComponents;

    private String name = "";

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr + "-" + name);
        if (this.childComponents != null) {
            preStr += "  ";
            for (Component component : childComponents) {
                component.printStruct(preStr);
            }
        }
    }

    public void addChild(Component component) {
        if (childComponents == null) {
            childComponents = Lists.newArrayList();
        }
        childComponents.add(component);
    }

    public void removeChild(Component component) {
        if (childComponents != null) {
            childComponents.remove(component);
        }
    }

    public Component getChildren(int index) {
        if (childComponents != null) {
            if (index > 0 && index < childComponents.size()) {
                return childComponents.get(index);
            }
        }
        return null;
    }
}
