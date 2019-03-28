package top.hengshare.interviewer.java8.optional;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/28
 * @description: 使用Optional的map和flatMap方法
 */
public class OptionalMap {
    public static void main(String[] args) {
        Java8OptionalTest test = new Java8OptionalTest();
        Optional<Java8OptionalTest> optional = Optional.of(test);

        Optional<Car> opt1 = optional.map(a -> a.getCar());
        System.out.println(opt1.get());
        //Car(weels=4)

        //未使用Optional类的时候，我们会按照下面的写法写
        int weel = 0;
        if (test != null) {
            if (test.getCar() != null) {
                weel = test.getCar().getWeels();
            }
        }
        System.out.println("传统：" + weel);
        //4

        Optional<Integer> opt2 = optional.map(a -> a.getCar()).map(b -> b.getWeels());
        System.out.println("Optional: " + opt2.get());
        //4

        Optional<Integer> opt3 = optional.map(a -> a.getList()).map(b -> b.size());
        System.out.println(opt3);
        //Optional.empty

        Optional<Car> opt4 = optional.flatMap(a -> Optional.of(a.getCar()));
        System.out.println(opt4);
        //Optional[Car(weels=4)]

        Optional<Integer> opt5 = optional.flatMap(a -> Optional.of(a.getCar())).flatMap(b -> Optional.ofNullable(b.getWeels()));
        System.out.println(opt5);
        //Optional[4]
    }
}
