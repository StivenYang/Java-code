package top.hengshare.interview.pattern.visitor.struct;

/**
 * @program: Java-Interview
 * @description: Visitor
 * @author: StivenYang
 * @create: 2019-11-03 18:17
 **/
public interface Visitor {

    /**
     * 访问元素A，相当于给元素A添加访问者的功能
     * @param elementA
     */
    void visitConcreteElementA(ConcreteElementA elementA);

    /**
     * 访问元素B，相当于给B添加访问者的功能
     * @param elementB
     */
    void visitConcreteElementB(ConcreteElementB elementB);
}
