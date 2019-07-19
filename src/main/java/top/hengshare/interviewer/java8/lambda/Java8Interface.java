package top.hengshare.interviewer.java8.lambda;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 在 @{HuaRao}中我们发现函数式接口的定义很简单，所以应该是可以共用的。
 * Java8中，已经提供了几个常用的函数式接口供我们使用，比如：
 * Comparable, Runnable, Callable, Predicate, Consumer, Function等
 * 下面我们来使用这些函数式接口
 */
public class Java8Interface {

    /**
     * java.util.function.Predicate<T>接口定义了一个名叫test的抽象方法，它接受泛型
     * T对象，并返回一个boolean。
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = Lists.newArrayList();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }

    /**
     * java.util.function.Consumer<T>定义了一个名叫accept的抽象方法，它接受泛型T
     * 的对象，没有返回（ void）。你如果需要访问类型T的对象，并对其执行某些操作，就可以使用
     * 这个接口。
     *
     * 你可以用它来创建一个forEach方法，接受一个Integers的列表，并对其中
     * 每个元素执行操作
     *
     * @param list
     * @param consumer
     * @param <T>
     */
    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T i: list) {
            consumer.accept(i);
        }
    }

    /**
     * java.util.function.Function<T, R>接口定义了一个叫作apply的方法，它接受一个
     * 泛型T的对象，并返回一个泛型R的对象。如果你需要定义一个Lambda，将输入对象的信息映射
     * 到输出，就可以使用这个接口（比如提取苹果的重量，或把字符串映射为它的长度）。
     *
     * 在下面的代码中，我们向你展示如何利用它来创建一个map方法，以将一个String列表映射到包含每个
     * String长度的Integer列表。
     * @param list
     * @param f
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> map(List<T> list, Function<T, R> f){
        ArrayList<R> result = Lists.newArrayList();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> listOfString = Lists.newArrayList();
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> filter = filter(listOfString, nonEmptyStringPredicate);
        System.out.println(filter);

        forEach(Arrays.asList(1,2,3,4,5), (System.out::println));

        List<Integer> map = map(Arrays.asList("lambdas", "in", "action"), (String::length));
        System.out.println(map);
    }

}
