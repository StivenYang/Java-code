package top.hengshare.interview.pattern.interpreter.example2;

import org.w3c.dom.Element;

import java.util.List;

/**
 * @program: Java-Interview
 * @description: 以多个元素的属性作为终结符的解释处理对象
 * @author: StivenYang
 * @create: 2019-10-29 18:50
 **/
public class PropertysTerminalExpression extends ReadXMLExpression {

	/**
	 * 属性名字
	 */
	private String propName;

	public PropertysTerminalExpression(String proName) {
		this.propName = proName;
	}

	@Override
	public String[] interpret(Context ctx) {
		//获取最后的多个元素
		List<Element> eles = ctx.getPreEles();

		String[] ss = new String[eles.size()];
		//循环多个元素，获取每个元素属性的值
		for (int i = 0; i < ss.length; i++) {
			ss[i] = eles.get(i).getAttribute(this.propName);
		}
		return ss;
	}
}
