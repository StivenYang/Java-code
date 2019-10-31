package top.hengshare.interview.pattern.decorator.struct;

import lombok.Data;
import lombok.Getter;

/**
 * @program: Java-Interview
 * @description: ConcreteDecorator
 * @author: StivenYang
 * @create: 2019-10-31 15:41
 **/
@Data
public class ConcreteDecoratorA extends Decorator {
    /**
     * 构造方法，传入组件对象
     *
     * @param component
     */
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    /**
     * 添加的状态
     */
    private String addedState;

    @Override
    public void operation() {
        //调用父类的方法，可以在调用前后执行一些附加动作
        //在这里进行处理的时候，可以使用添加的状态
        super.operation();
    }
}
