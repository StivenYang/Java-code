package top.hengshare.interview.pattern.visitor.struct;

/**
 * @program: Java-Interview
 * @description: ConcreteVisitorA
 * @author: StivenYang
 * @create: 2019-11-03 18:22
 **/
public class ConcreteVisitorA implements Visitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA elementA) {
        //把要访问ConcreteElementA时，需要执行的功能实现在这里
        //可能需要访问元素已有的功能
        elementA.operationA();
    }

    @Override
    public void visitConcreteElementB(ConcreteElementB elementB) {
        //把要访问ConcreteElementA时，需要执行的功能实现在这里
        //可能需要访问元素已有的功能
        elementB.operationB();
    }
}
