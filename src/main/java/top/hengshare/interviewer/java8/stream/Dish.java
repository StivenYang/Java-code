package top.hengshare.interviewer.java8.stream;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Data
public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public enum Type {MEAT, FISH, OTHER}

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
                new Dish("salmon", false, 450, Dish.Type.FISH));

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
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //跳过元素
        menu.stream()
                .filter(d -> d.getCalories() > 300)
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
        //错误示范1
        List<String> words = Arrays.asList("我是一个程序员", "我喜欢写程序");
        words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList())
                .forEach(System.out::println);
        //此处输出：[Ljava.lang.String;@1e80bfe8
        //[Ljava.lang.String;@66a29884
        //错误示范2
        words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList())
                .forEach(System.out::println);
        //输出：java.util.stream.ReferencePipeline$Head@79fc0f2f
        //java.util.stream.ReferencePipeline$Head@50040f0c
        //正确示范
        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList())
                .forEach(System.out::print);
        //输出：我是一个程序员喜欢写

        //示例
        //给定两个数字列表，如何返回所有的数对呢？例如，给定列表[1, 2, 3]和列表[3, 4]，应
        //该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。为简单起见，你可以用有两个元素的数组来代表数对。
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j})
                )
                .collect(toList())
                .forEach(a -> System.out.println(a[0] + "," + a[1]));

        //查找和匹配
        //检查集合中是否至少匹配一个元素
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("这个菜单里面有蔬菜");
        }

        //检查谓词是否匹配所有元素,相对应的是noneMatch()
        boolean isHealthy = menu.stream()
                .allMatch(d -> d.getCalories() < 1000);
        System.out.println(isHealthy);

        //查找元素
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(System.out::println);

        //查找第一个元素
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        someNumbers.stream()
                .map(x -> x * x)
                .filter(x -> x % 3 == 0)
                .findFirst()
                .ifPresent(System.out::println); // 9

        //元素求和
        numbers.stream()
                .reduce((a, b) -> (a + b))
                .ifPresent(System.out::println);

        //最大值和最小值
        numbers.stream().reduce(Integer::max).ifPresent(System.out::println);
        numbers.stream().reduce(Integer::min).ifPresent(System.out::println);

        //对流中的数据进行计数
        System.out.println(menu.stream().count());
        //使用map-reduce进行计数（容易并行化）
        menu.stream()
                .map(d -> 1)
                .reduce((a, b) -> a+b)
                .ifPresent(System.out::println);

        //映射到数值流，mapToInt\mapToDouble\mapToLong
        int sum = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(sum);
        //请注意，如果流是空的， sum默认返回0。 IntStream还支持其他的方便方法，如max、 min、 average等。

        //转换为对象流
        IntStream intStream = menu.stream()
                .mapToInt(Dish::getCalories);
        Stream<Integer> boxed = intStream.boxed();
        System.out.println(boxed);

        //默认值OptionalInt
        OptionalInt max = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        //如果存在就输出
        max.ifPresent(System.out::println);
        //如果不存在就使用默认值1
        int i = max.orElse(1);
        System.out.println(max);

        //数值范围
        long count = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println(count);
        long count1 = IntStream.range(1, 100)
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println(count1);

        //勾股数


    }
}
