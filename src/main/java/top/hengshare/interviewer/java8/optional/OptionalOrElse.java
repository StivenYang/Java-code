package top.hengshare.interviewer.java8.optional;

import java.util.Optional;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/28
 * @description:
 */
public class OptionalOrElse {
    public static void main(String[] args) {
        Java8OptionalTest one = null;
        Java8OptionalTest test = new Java8OptionalTest();
        Optional<Java8OptionalTest> optional = Optional.ofNullable(one);
        System.out.println(optional);
        //Optional.empty
        System.out.println(optional.orElse(test));
        //Java8OptionalTest(list=null, car=Car(weels=4))
        System.out.println(optional.orElseGet(() -> new Java8OptionalTest()));
        //Java8OptionalTest(list=null, car=Car(weels=4))
        System.out.println(optional.orElseThrow(() -> new RuntimeException("OrElseThrow")));

    }
}
