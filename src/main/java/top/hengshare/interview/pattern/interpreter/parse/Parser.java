package top.hengshare.interview.pattern.interpreter.parse;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import top.hengshare.interview.pattern.interpreter.example2.*;

import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @program: Java-Interview
 * @description: 根据语法来解析表达式，转换为相应的抽象语法树
 *  todo： 针对表达式：root/a/b/d$.id 还有个bug，暂时不修复了，之后修复
 * @author: StivenYang
 * @create: 2019-10-29 20:07
 **/
public class Parser {

	private Parser() {
	}

	//定义几个常量，内部使用
	private final static String BACKLASH = "/";
	private final static String DOT = ".";
	private final static String DOLLAR = "$";

	/**
	 * 按照分解的先后记录，需要解析的元素的名称
	 */
	private static List<String> listEle = null;

	public static ReadXMLExpression parse(String expr) {
		//先初始化记录需解析的元素名称的集合
		listEle = Lists.newArrayList();

		//1. 分解表达式，得到需要解析的元素名称和该元素对应的解析模型
		Map<String, ParserModel> mapPath = parseMapPath(expr);

		//2. 根据节点的属性解析为对应的解释器对象
		List<ReadXMLExpression> list = mapPath2Interpreter(mapPath);

		//3. 结合抽象语法树，按照先后顺序来组合元素
		//否则对象的包含关系就乱了

		return buildTree(list);
	}

	private static ReadXMLExpression buildTree(List<ReadXMLExpression> list) {
		//构建树
		//第一个对象，也是返回去的对象，就是抽象语法树的根
		ReadXMLExpression returnRe = null;
		//定义上一个对象
		ReadXMLExpression preRe = null;
		for (ReadXMLExpression re : list) {
			if (preRe == null) {
				//说明是第一个元素
				preRe = re;
				returnRe = re;
			} else {
				if (preRe instanceof ElementExpression) {
					//不是第一个元素的花，就把元素添加到上一个元素的下面,同时把对象设置成oldRe
					ElementExpression ele = (ElementExpression) preRe;
					ele.addEle(re);
					preRe = re;
				} else if (preRe instanceof ElementExpression) {
					ElementsExpression eles = (ElementsExpression) preRe;
					eles.addEle(re);
					preRe = re;
				}
			}
		}
		return returnRe;
	}

	/**
	 * 把分解出来的元素名称根据对应的解析模型转换成为相应的解释器对象
	 * @param mapPath 分解出来的需要解析的元素名称，还有该元素对应的解析模型
	 * @return 把每个元素转换成为相应的解析器对象后的集合
	 */
	private static List<ReadXMLExpression> mapPath2Interpreter(Map<String, ParserModel> mapPath) {
		List<ReadXMLExpression> list = Lists.newArrayList();
		//一定要按照分解的先后顺序来转换成解释器对象
		for (String key : listEle) {
			ParserModel parserModel = mapPath.get(key);
			ReadXMLExpression obj = null;
			if (!parserModel.isEnd()) {
				if (parserModel.isSingleValue()) {
					//如果是一个值
					obj = new ElementExpression(key);
				} else {
					//是多个之
					obj = new ElementsExpression(key);
				}
			} else {
				if (parserModel.isPropertyValue()) {
					if (parserModel.isSingleValue()) {
						//是最后一个，是一个值，取属性的之
						obj = new PropertyTerminalExpression(key);
					} else {
						//是最后一个，是多个之，取属性的值
						obj = new PropertysTerminalExpression(key);
					}
				} else {
					if (parserModel.isSingleValue()) {
						//是最后一个，是一个值
						obj = new ElementTerminalExpression(key);
					} else {
						//是最后一个，取多个元素的之
						obj = new ElementsTerminalExpression(key);
					}
				}
			}
			//把转换后的对象添加到集合中
			list.add(obj);
		}
		return list;
	}

	/**
	 * 按照从左到右的顺序来分解表达式，得到需要解析的元素名称
	 * 还有该元素对应的解析模型
	 *
	 * @param expr 需要分解的表达式
	 * @return 得到需要解析的元素名称，还有该元素对应的解析模型
	 */
	private static Map<String, ParserModel> parseMapPath(String expr) {
		//先按照/分割字符串
		StringTokenizer stringTokenizer = new StringTokenizer(expr, BACKLASH);

		//初始化一个map用来存放分解出来的值
		Map<String, ParserModel> mapPath = Maps.newHashMap();

		while (stringTokenizer.hasMoreTokens()) {
			String onePath = stringTokenizer.nextToken();
			if (stringTokenizer.hasMoreTokens()) {
				//还有下一个值，说明这不是最后一个元素
				//按照现在的语法，属性必然在最后，因此也不是属性
				setParsePath(false, onePath, false, mapPath);
			} else {
				//说明到最后了
				int dotIndex = onePath.indexOf(DOT);
				if (dotIndex > 0) {
					//说明是要获取属性的值，那就按照"."来分割
					//前面的就是元素名字，后面的是属性的名字
					String eleName = onePath.substring(0, dotIndex);
					String propName = onePath.substring(dotIndex + 1);

					//设置属性前面的那个元素，自然不是最后一个，也不是属性
					setParsePath(false, eleName, false, mapPath);
					//设置属性，按照现在的语法定义，属性只能是最后一个
					setParsePath(true, propName, true, mapPath);
				} else {
					//说明是取元素的值，而且是最后一个元素的值
					setParsePath(true, onePath, false, mapPath);
				}
				break;
			}
		}
		return mapPath;
	}

	/**
	 * 按照分解出来的位置和名称来设置需要解析的元素和名称、对应的解析模型
	 *
	 * @param end       是否是最后一个
	 * @param ele       元素名称
	 * @param propValue 是否取属性
	 * @param mapPath   设置需要解析的元素名称，还有该元素对应的解析模型的Map
	 */
	private static void setParsePath(boolean end, String ele, boolean propValue, Map<String, ParserModel> mapPath) {
		ParserModel pm = new ParserModel();
		pm.setEnd(end);
		//如果带有$符号就说明不是一个值
		pm.setSingleValue(!(ele.indexOf(DOLLAR) > 0));
		pm.setPropertyValue(propValue);
		//去掉$
		ele = ele.replace(DOLLAR, "");
		mapPath.put(ele, pm);
		listEle.add(ele);
	}


}
