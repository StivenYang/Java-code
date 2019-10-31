package top.hengshare.interview.pattern.interpreter.example2;

import com.google.common.collect.Lists;
import org.w3c.dom.Element;

import java.util.List;

/**
 * @program: Java-Interview
 * @description: 元素作为终结符的解释器
 * @author: StivenYang
 * @create: 2019-10-24 21:34
 **/
public class ElementTerminalExpression extends ReadXMLExpression {

    /**
     * 元素的名字
     */
    private String eleName;

    public ElementTerminalExpression(String eleName) {
        this.eleName = eleName;
    }

    /**
     * 叶子节点解释器
     * @param ctx 上下文
     * @return
     */
    @Override
    public String[] interpret(Context ctx) {
        //先取出上下文中的当前元素作为父级元素
        List<Element> preEle = ctx.getPreEles();
        //查找当前元素名称所对象的元素
        Element element = null;
        if (preEle.size() == 0) {
            element = ctx.getDocument().getDocumentElement();
        }else {
            element = ctx.getNowEles(preEle.get(0), eleName).get(0);
        }

        //然后需要去获取这个元素的值
        String[] ss = new String[1];
        ss[0] =  element.getFirstChild().getNodeValue();
        return ss;

    }
}
