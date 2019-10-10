package top.hengshare.interview.pattern.FactoryMethod;

/**
 * 具体的创建器对象
 */
public class ConcreteCreator extends Creator {
    @Override
    protected Product factoryMethod() {
        //重定义factory方法，返回一个具体的Product对象
        return new ConcreteProduct();
    }
}
