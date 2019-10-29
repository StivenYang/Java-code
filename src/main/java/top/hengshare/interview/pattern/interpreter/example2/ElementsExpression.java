package top.hengshare.interview.pattern.interpreter.example2;

import com.google.common.collect.Lists;
import org.w3c.dom.Element;

import java.util.Collection;
import java.util.List;

/**
 * @program: Java-Interview
 * @description: 多个元素作为非终结符的解释处理对象
 * @author: StivenYang
 * @create: 2019-10-29 19:04
 **/
public class ElementsExpression extends ReadXMLExpression {

    /**
     * 用来记录组合的ReadXMLExpression元素集合
     */
    private Collection<ReadXMLExpression> eles = Lists.newArrayList();

    /**
     * 元素名字
     */
    private String eleName;

    public ElementsExpression(String eleName) {
        this.eleName = eleName;
    }

    /**
     *
     * @param ctx 上下文
     * @return
     */
    @Override
    public String[] interpret(Context ctx) {
       //1. 先取出父级元素
        List<Element> preEles = ctx.getPreEles();

        //2. 把当前元素放到上下文中，这次是获取多个元素
        List<Element> nowEles = Lists.newArrayList();

        for (Element preEle : preEles) {
            nowEles.addAll(ctx.getNowEles(preEle, eleName));
        }

        ctx.setPreEles(nowEles);

        //3. 循环调用子元素的interpret方法
        String[] ss = null;
        for (ReadXMLExpression ele : eles) {
            ss = ele.interpret(ctx);
        }

        return ss;
    }

    /**
     * 新增元素
     * @param ele 新增元素
     * @return 成功
     */
    public boolean addEle(ReadXMLExpression ele){
        this.eles.add(ele);
        return true;
    }

    /**
     * 移除元素
     * @param ele 要移除的元素
     * @return true成功
     */
    public boolean removeEle(ReadXMLExpression ele){
        this.eles.remove(ele);
        return true;
    }

}
