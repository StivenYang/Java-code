package top.hengshare.interview.pattern.composite.parentRef;

import java.util.List;

public abstract class Component {
    private Component parent;

    public Component getParent(){
        return parent;
    }

    public void setParent(Component parent){
        this.parent = parent;
    }

    public List<Component> getChildren() {
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    public abstract void printStruct(String preStr);

    public void addChild(Component component){
        throw new UnsupportedOperationException("对象不支持这个功能");
    }

    public void removeChild(Component component){
        throw new UnsupportedOperationException("对象不支持这个功能");
    }
}
