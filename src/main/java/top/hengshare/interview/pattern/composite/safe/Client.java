package top.hengshare.interview.pattern.composite.safe;

public class Client {
    public static void main(String[] args) {
        //定义多个组合对象
        Composite root = new Composite("服装");
        Composite c1 = new Composite("男装");
        Composite c2 = new Composite("女装");
        //定义多个叶子节点
        Leaf l1 = new Leaf("衬衣");
        Leaf l2 = new Leaf("夹克");
        Leaf l3 = new Leaf("裙子");
        Leaf l4 = new Leaf("套装");
        //组合为树形结构
        root.addChild(c1);
        root.addChild(c2);
        c1.addChild(l1);
        c1.addChild(l2);
        c2.addChild(l3);
        c2.addChild(l4);
        //操作组合对象
        root.printStruct("");
    }
}
