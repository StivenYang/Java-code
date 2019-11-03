package top.hengshare.interview.pattern.visitor.struct;

import com.google.common.collect.Lists;

import java.util.Collection;

/**
 * @program: Java-Interview
 * @description: ObjectStructure
 * @author: StivenYang
 * @create: 2019-11-03 18:25
 **/
public class ObjectStructure {

    /**
     * 表示对象结构，可以是一个组合结构或是集合
     */
    private Collection<Element> col = Lists.newArrayList();

    /**
     * 提供给客户端操作的高层接口
     * @param visitor 客户端需要使用的访问者
     */
    public void handleRequest(Visitor visitor){
        //循环对象结构中的元素，接受访问
        for (Element element : col) {
            element.accept(visitor);
        }
    }

    /**
     * 组建对象结构，向对象结构中添加元素
     * @param element 加入到对象结构的元素
     */
    public void addElement(Element element){
        this.col.add(element);
    }
}
