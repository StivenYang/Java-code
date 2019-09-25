package top.hengshare.interview.pattern.simpleFactory;

/**
 * 接口实现：猫
 */
public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    @Override
    public void sleep() {
        System.out.println("猫睡觉");
    }
}
