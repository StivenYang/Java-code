package top.hengshare.interview.pattern.interpreter.example;

/**
 * @program: Java-Interview
 * @description: ReadXMLExpression
 * @author: StivenYang
 * @create: 2019-10-24 20:56
 **/
public abstract class ReadXMLExpression {
	/**
	 * 解释表达式
	 * @param ctx 上下文
	 * @return 解析后的值，因为有可能是单个值，也有可能是多个值，所以这里写成数组
	 */
	public abstract String[] interpret(Context ctx);
}
