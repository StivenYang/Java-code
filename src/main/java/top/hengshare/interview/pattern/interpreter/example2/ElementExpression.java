package top.hengshare.interview.pattern.interpreter.example2;

import com.google.common.collect.Lists;
import org.w3c.dom.Element;

import java.util.Collection;
import java.util.List;

/**
 * @program: Java-Interview
 * @description: 元素作为非终结符对应的解释器
 * @author: StivenYang
 * @create: 2019-10-24 21:21
 **/
public class ElementExpression extends ReadXMLExpression {

	/**
	 * 用来记录组合的xml元素
	 */
	private Collection<ReadXMLExpression> eles = Lists.newArrayList();

	/**
	 * 用来表示元素的名称
	 */
	private String eleName;

	public ElementExpression(String eleName) {
		this.eleName = eleName;
	}

	public boolean addEle(ReadXMLExpression ele) {
		this.eles.add(ele);
		return true;
	}

	public boolean removeEle(ReadXMLExpression ele) {
		this.eles.remove(ele);
		return true;
	}

	/**
	 * 解释方式
	 * @param ctx 上下文
	 * @return
	 */
	@Override
	public String[] interpret(Context ctx) {
		//先取出当前元素作为父级元素
		//查找当前元素名称对应的xml元素，并设置回到上下文中
		List<Element> preEle = ctx.getPreEles();
		Element ele;

		//把当前获取的元素放到上下文中
		List<Element> nowEles = Lists.newArrayList();
		if (preEle.size() == 0) {
			//说明现在获取的是根元素
			ele = ctx.getDocument().getDocumentElement();
			preEle.add(ele);
			ctx.setPreEles(preEle);
		} else {
			//不是根元素，则根据父级元素和当前要查找的元素名称查找元素
			for (Element element : preEle) {
				nowEles.addAll(ctx.getNowEles(element, eleName));
				if (nowEles.size() > 0) {
					break;
				}
			}
			List<Element> tempList = Lists.newArrayList();
			tempList.add(nowEles.get(0));
			ctx.setPreEles(tempList);
		}

		//循环调用子元素的interpret方法
		String[] ss = null;
		for (ReadXMLExpression tempEle : eles) {
			ss = tempEle.interpret(ctx);
		}

		return ss;
	}
}
