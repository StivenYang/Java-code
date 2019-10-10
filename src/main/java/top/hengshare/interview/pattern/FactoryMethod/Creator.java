package top.hengshare.interview.pattern.FactoryMethod;

/**
 * 创建器，用来声明工厂方法
 */
public abstract class Creator {

    /**
     * 创建所需对象的工厂方法
     * @return
     */
    protected abstract Product factoryMethod();

    /**
     * 一些其他的方法
     */
    public void someOperation(){

    }
}
