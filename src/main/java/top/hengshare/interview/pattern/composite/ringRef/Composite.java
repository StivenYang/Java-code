package top.hengshare.interview.pattern.composite.ringRef;

import com.google.common.collect.Lists;

import java.util.List;

public class Composite extends Component {

    private List<Component> childComponents;

    private String name = "";

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
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
//        childComponents.add(component);

        //判断当前对象是否是根节点，如果是，设置componentpath，否则，判断是否出现过，然后进行添加
        if (this.getComponentPath() == null || this.getComponentPath().trim().length() == 0) {
            this.setComponentPath(this.name);
        }

        //判断是否是根节点，如果是根节点，抛出异常
        if (this.getComponentPath().startsWith(component.getName() + ".")) {
            //如果是以该节点名开头的，说明是根节点，且重复添加了，跑出异常
            throw new IllegalArgumentException("在本通路上，根组件“" + component.getName() + "”已经添加过了");
        } else {
            //如果不是根节点，判断是否曾经出现过
            //没有出现过，进行添加
            if (!this.getComponentPath().contains("." + component.getName())) {
                //表示没有出现过将添加的节点
                childComponents.add(component);
                String componentPath = this.getComponentPath() + "." + component.getName();
                component.setComponentPath(componentPath);
            } else {
                //如果出现过，抛出节点已经添加过异常
                throw new IllegalArgumentException("在本通路上，组件“" + component.getName() + "”已经添加过了");
            }
        }
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
