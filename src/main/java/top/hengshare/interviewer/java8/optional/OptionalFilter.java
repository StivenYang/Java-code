package top.hengshare.interviewer.java8.optional;

import java.util.Optional;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/28
 * @description:
 */
public class OptionalFilter {
    public static void main(String[] args) {
        Java8OptionalTest test = new Java8OptionalTest();

        Optional<Java8OptionalTest> optional = Optional.of(test);

        Optional<Java8OptionalTest> result = optional.filter(a -> a.getCar() != null).filter(b -> b.getClass().getName() != null);
        System.out.println(result.isPresent() ? result.get().getClass().getName() : result.isPresent());
        //top.hengshare.interviewer.java8.optional.Java8OptionalTest

        Optional<Java8OptionalTest> result1 = optional.filter(a -> a.getList() != null);
        System.out.println(result1.get());
        //java.util.NoSuchElementException: No value present
    }
}
