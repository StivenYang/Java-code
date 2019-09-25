package top.hengshare.interview.pattern.simpleFactory;

/**
 * 接口实现：狗
 */
public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("狗啃骨头");
    }

    @Override
    public void sleep() {
        System.out.println("狗睡觉");
    }
}
