package top.hengshare.interviewer.java8.lambda;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author StivenYang
 * @program interview
 * @description 这是一个苹果Apple
 * @date 2019-06-28 10:20
 **/
@Data
public class Apple {

    public Apple(String color) {
        this.color = color;
    }

    private String color;

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        ArrayList<Apple> result = Lists.newArrayList();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Apple> appleList = Lists.newArrayList();
        Apple green = new Apple("green");
        appleList.add(green);
        System.out.println(green);
        Apple red = new Apple("red");
        appleList.add(red);
        System.out.println(red);
        System.out.println(appleList);
        List<Apple> apples = Apple.filterApples(appleList, Apple::isGreenApple);
        System.out.println(apples);
    }
}
    