package top.hengshare.interview.java8.optional;

import lombok.Data;

import java.util.List;
import java.util.Optional;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/28
 * @description: Optional类使用练习
 * 该类可以有效避免空指针异常
 */
@Data
public class OptionalTest {
    public static void main(String[] args) {
        Java8OptionalTest test = new Java8OptionalTest();
        Optional<Java8OptionalTest> optional = Optional.of(test);

        System.out.println(optional.isPresent());
        //true
        optional.ifPresent(a -> System.out.println(a.getCar().getClass().getName()));
        //top.hengshare.interviewer.java8.optional.Car
        optional.ifPresent(a -> Optional.ofNullable(a.getList()).ifPresent(b -> System.out.println("StringList: " + (b == null))));
        //第一级的ifPresent存在test对象，所以执行了
        optional.ifPresent(a -> Optional.ofNullable(a.getCar()).ifPresent(b -> System.out.println("car: " + (b == null))));
        //car: false
        //第二级ifPresent的car对象是存在的，所以第二级的表达式执行了
    }
}

/**
 * 测试用类
 */
@Data
class Java8OptionalTest {
    List<String> list = null;
    Car car = new Car();
}

@Data
class Car {
    Integer weels = new Integer(4);
}
