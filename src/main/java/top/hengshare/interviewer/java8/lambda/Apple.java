package top.hengshare.interviewer.java8.lambda;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static com.google.common.collect.Collections2.filter;

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

    private Double weight;

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple: inventory){
            if( "green".equals(apple.getColor()) ){
                result.add(apple);
            }
        }
        return result;
    }

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
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple: inventory){
            if ( apple.getColor().equals(color) ) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, String color,
                                           double weight, boolean flag) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple: inventory){
            if ( (flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() > weight) ){
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> appleList = Lists.newArrayList();
        Apple green = new Apple("green");
        green.setWeight(2D);
        appleList.add(green);
        Apple red = new Apple("red");
        red.setWeight(3D);
        appleList.add(red);
        System.out.println(appleList);
        //第一次尝试：直接自定义函数，筛选绿色苹果
        List<Apple> list1 = Apple.filterGreenApples(appleList);
        System.out.println(list1);
        //第二次尝试：定义函数，传入苹果的颜色
        List<Apple> list2 = Apple.filterApplesByColor(appleList, "green");
        System.out.println(list2);
        //第三次尝试：定义函数，传入重量作为参数
        List<Apple> list3 = Apple.filterApplesByWeight(list2, 2D);
        System.out.println(list3);
        //第四次尝试：定义函数，同时传入重量和颜色作为参数,另加一个boolean对参数进行筛选
        List<Apple> list4 = Apple.filterApples(appleList, "green", 2D, false);
        System.out.println(list4);
        //第五次尝试: 使用自定义的filterApples,第二个参数为谓词，通过谓词来对列表中的内容进行筛选
        List<Apple> apples = Apple.filterApples(appleList, Apple::isGreenApple);
        System.out.println(apples);
        //第六次尝试：使用lambda表达式，简化我们上面的代码，让它更加容易阅读（但是有一个缺点是，需要自己定义一个filterApples函数
        List<Apple> list6 = Apple.filterApples(appleList, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(list6);
        //第七次尝试：使用lambda表达式，并且使用google提供的filter工具
        Collection<Apple> list7 = filter(appleList, (Apple apple) -> "red".equals(apple.getColor()));
        System.out.println(list7);

        //对list进行排序
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });
        System.out.println(appleList);
        //使用lambda表达式对list进行排序
        appleList.sort((Apple a1, Apple a2) -> a2.getColor().compareTo(a1.getColor()));
        System.out.println(appleList);

    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, double weight) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple: inventory){
            if ( apple.getWeight() > weight ){
                result.add(apple);
            }
        }
        return result;
    }
}
