package top.hengshare.interview.pattern.interpreter.example2;

import org.w3c.dom.Element;

import java.util.List;

/**
 * @program: Java-Interview
 * @description: PropertyTerminalExpression
 * @author: StivenYang
 * @create: 2019-10-24 21:45
 **/
public class PropertyTerminalExpression extends ReadXMLExpression {

    /**
     * 属性名称
     */
    private String propName;

    public PropertyTerminalExpression(String propName) {
        this.propName = propName;
    }

    /**
     * 定义某个属性作为终结符
     * @param ctx 上下文
     * @return
     */
    @Override
    public String[] interpret(Context ctx) {
        List<Element> preEles = ctx.getPreEles();
        //直接获取最后的元素属性的值
        String[] ss = new String[preEles.size()];
        for (int i = 0; i< preEles.size(); i++){
            ss[i] = preEles.get(i).getAttribute(this.propName);
        }
        return ss;
    }
}
