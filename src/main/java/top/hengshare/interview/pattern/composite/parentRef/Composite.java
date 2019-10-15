package top.hengshare.interview.pattern.composite.parentRef;

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

    @Override
    public void addChild(Component component) {
        if (childComponents == null) {
            childComponents = Lists.newArrayList();
        }
        childComponents.add(component);

        component.setParent(this);
    }

    @Override
    public void removeChild(Component children) {
        if (childComponents != null) {
            int idx = childComponents.indexOf(children);
            if (idx != -1) {
                for (Component childComponent : children.getChildren()) {
                    childComponent.setParent(this);
                    childComponents.add(childComponent);
                }

                childComponents.remove(idx);
            }
        }
    }

    @Override
    public List<Component> getChildren() {
        return childComponents;
    }
}
