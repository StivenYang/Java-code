package top.hengshare.interview.pattern.bridge.struct;

/**
 * @program: Java-Interview
 * @description: Abstraction
 * @author: StivenYang
 * @create: 2019-11-02 19:51
 **/
public abstract class Abstraction {
    /**
     * 持有一个实现部分的对象
     */
    protected Implementor impl;

    public Abstraction(Implementor impl) {
        this.impl = impl;
    }

    /**
     * 实现一定的功能，可能需要转掉实现部分的具体实现方法
     */
    public void operation(){
        impl.operationImpl();
    }
}
