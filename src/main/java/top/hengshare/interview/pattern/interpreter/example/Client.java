package top.hengshare.interview.pattern.interpreter.example;

/**
 * @program: Java-Interview
 * @description: 使用解释器
 * @author: StivenYang
 * @create: 2019-10-24 21:48
 **/
public class Client {
	public static void main(String[] args) throws Exception {
		//准备上下文
		Context ctx = new Context("test.xml");

		//想要获取 c元素 的值，也就是"root/a/b/c"
		//首先要构建解释器的抽象语法树
		ElementExpression root = new ElementExpression("root");
		ElementExpression a = new ElementExpression("a");
		ElementExpression b = new ElementExpression("b");
		ElementTerminalExpression c = new ElementTerminalExpression("c");

		//组合起来
		root.addEle(a);
		a.addEle(b);
		b.addEle(c);

		//调用
		String[] ss = root.interpret(ctx);
		System.out.println("c的值是：" + ss[0]);
	}
}
