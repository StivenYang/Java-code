package top.hengshare.interview.pattern.interpreter.parse;

import top.hengshare.interview.pattern.interpreter.example2.Context;
import top.hengshare.interview.pattern.interpreter.example2.ReadXMLExpression;

/**
 * @program: Java-Interview
 * @description: Client
 * @author: StivenYang
 * @create: 2019-10-31 01:10
 **/
public class Client {
	public static void main(String[] args) throws Exception {
		//准备上下文
		Context c = new Context("test.xml");
		//通过解析器获取抽象语法树
		ReadXMLExpression parse = Parser.parse("root/a/b/d");
		//请求解析获取返回值
		String[] ss = parse.interpret(c);

		for (String s : ss) {
			System.out.println("d的属性id值是：" + s);
		}

		//如果要使用同一个上下文，连续进行解析，需要重新初始化上下文对象
		c.reInit();
		ReadXMLExpression parse1 = Parser.parse("root/a/b/d$");
		//请求解析，获取返回值
		String[] ss2 = parse1.interpret(c);
		for (String s : ss2) {
			System.out.println("d的值是=" + s);
		}

		//如果要使用同一个上下文，连续进行解析，需要重新初始化上下文对象
		c.reInit();
		ReadXMLExpression parse2 = Parser.parse("root/a/b/d.id");
		//请求解析，获取返回值
		String[] ss3 = parse2.interpret(c);
		for (String s : ss3) {
			System.out.println("d的id值是=" + s);
		}

		//如果要使用同一个上下文，连续进行解析，需要重新初始化上下文对象
		c.reInit();
		ReadXMLExpression parse3 = Parser.parse("root/a/b/d$.id");
		//请求解析，获取返回值
		String[] ss4 = parse3.interpret(c);
		for (String s : ss4) {
			System.out.println("d的id值是=" + s);
		}
	}
}
