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
        List<Element> nowEles = Lists.newArrayList();
        if (preEle == null) {
            //说明现在获取的是根元素
            ctx.getDocument().getDocumentElement();
            nowEles.add(element);
            ctx.setPreEles(nowEles);
        }else {
            //根据父级元素和当前有的元素名字查找当前元素
            for (Element element1 : preEle) {
                nowEles.addAll(ctx.getNowEles(element1, eleName));
            }
            //吧当前获取的元素放到上下文中
            ctx.setPreEles(nowEles);
        }

        //然后需要去获取这个元素的值
        String[] ss = new String[nowEles.size()];
        for (int i = 0 ;i < nowEles.size(); i++){
            ss[i] = nowEles.get(i).getNodeValue();
        }
        return ss;

    }
}
