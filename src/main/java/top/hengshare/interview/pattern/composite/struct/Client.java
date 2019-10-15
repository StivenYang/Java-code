package top.hengshare.interview.pattern.composite.struct;

public class Client {
    public static void main(String[] args) {
        //定义多个组合对象
        Component root = new Composite();
        Component c1 = new Composite();
        Component c2 = new Composite();
        //定义多个叶子节点
        Component l1 = new Leaf();
        Component l2 = new Leaf();
        Component l3 = new Leaf();
        //组合为树形结构
        root.addChild(c1);
        root.addChild(c2);
        root.addChild(l1);
        c1.addChild(l2);
        c2.addChild(l3);
        //操作组合对象
        Component children = root.getChildren(1);
        System.out.println(children);
    }
}
