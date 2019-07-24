package top.hengshare.interviewer.java8.stream;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Data
public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public enum Type { MEAT, FISH, OTHER }

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        //用谓词筛选流
        menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList())
                .forEach(System.out::println);

        //筛选各异的元素
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        //截断流
        menu.stream()
                .filter(d -> d.getCalories()>300)
                .limit(3)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //跳过元素
        menu.stream()
                .filter(d -> d.getCalories()>300)
                .skip(3)
                .collect(toList())
                .forEach(System.out::println);

        //对流中的每个元素应用函数
        menu.stream()
                .map(Dish::getName)
                .collect(toList())
                .forEach(System.out::println);

        //流的扁平化
        //要找到一串文字中的所有不重复的字符
        //错误示范
        List<String> words = Arrays.asList("我是一个程序员", "我喜欢写程序");
        words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList())
                .forEach(System.out::println);
    }
}
