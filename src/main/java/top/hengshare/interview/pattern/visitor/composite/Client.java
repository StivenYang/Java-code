package top.hengshare.interview.pattern.visitor.composite;

/**
 * @program: Java-Interview
 * @description: Client
 * @author: StivenYang
 * @create: 2019-11-05 16:20
 **/
public class Client {
	public static void main(String[] args) {
		//定义所有的组合对象
		Composite root = new Composite("服装");
		Composite c1 = new Composite("男装");
		Composite c2 = new Composite("女装");
		//定义所有的叶子节点
		Leaf l1 = new Leaf("衬衣");
		Leaf l2 = new Leaf("夹克");
		Leaf l3 = new Leaf("裙子");
		Leaf l4 = new Leaf("套装");

		//按照树的结构来组合对象结构
		root.addChild(c1);
		root.addChild(c2);

		c1.addChild(l1);
		c1.addChild(l2);

		c2.addChild(l3);
		c2.addChild(l4);

		//创建ObjectStructure
		ObjectStructure structure = new ObjectStructure();
		structure.setRoot(root);

		//调用ObjectStructure来处理请求功能
		PrintNameVisitor visitor = new PrintNameVisitor();
		structure.handleRequest(visitor);
	}
}
