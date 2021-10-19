package top.hengshare.interview.pattern.composite.ringRef;

public class Client {
	//可能这样删除的时候可能不太方便，可以采用 动态计算路径的方式，
	// 每次添加组件的时候，动态递归查找父组件，如果可以找到根组件，就添加，否则不予添加
	public static void main(String[] args) {
		//定义多个组合对象
		Component root = new Composite("服装");
		Component c1 = new Composite("男装");
		Component c2 = new Composite("女装");
		Component c3 = new Composite("男装");
		//定义多个叶子节点
		Component l1 = new Leaf("衬衣");
		Component l2 = new Leaf("夹克");
		Component l3 = new Leaf("裙子");
		Component l4 = new Leaf("套装");
		//组合为树形结构
		root.addChild(c1);
		root.addChild(c2);
		c1.addChild(l1);
		c1.addChild(l2);
		//        c1.addChild(c3);//循环引用，抛出异常
		//        c1.addChild(root);//循环引用根组件，抛出异常
		c2.addChild(l3);
		c2.addChild(l4);
		//操作组合对象
		root.printStruct("");
	}
}
