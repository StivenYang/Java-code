package top.hengshare.interview.pattern.interpreter.example2;

import com.google.common.collect.Lists;
import org.w3c.dom.Element;

import java.util.List;

/**
 * @program: Java-Interview
 * @description: 以多个元素作为终结符的解释处理对象
 * @author: StivenYang
 * @create: 2019-10-29 18:57
 **/
public class ElementsTerminalExpression extends ReadXMLExpression {

    /**
     * 元素的名称
     */
    private String eleName;

    public ElementsTerminalExpression(String eleName) {
        this.eleName = eleName;
    }

    /**
     *
     * @param ctx 上下文
     * @return
     */
    @Override
    public String[] interpret(Context ctx) {
        //取出上下文的父级元素
        List<Element> preEles = ctx.getPreEles();

        //获取当前的多个元素
        List<Element> nowElements = Lists.newArrayList();

        for (Element preEle : preEles) {
            nowElements.addAll(ctx.getNowEles(preEle, eleName));
        }

        //然后来获取这些元素的值
        String[] ss = new String[nowElements.size()];
        for (int i=0; i<ss.length; i++){
            ss[i] = nowElements.get(i).getFirstChild().getNodeValue();
        }
        return ss;
    }
}
