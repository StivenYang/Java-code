package top.hengshare.interview.java8.lambda;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static top.hengshare.interview.java8.lambda.Java8Interface.filter;

public class Complex {
	public static void main(String[] args) {
		List<Apple> appleList = Lists.newArrayList();
		Apple green = new Apple("green");
		green.setWeight(2D);
		appleList.add(green);
		Apple red = new Apple("red");
		red.setWeight(3D);
		appleList.add(red);

		//比较器复合
		//好处：简单排序很方便
		//逆序排序一个数组
		appleList.sort(Comparator.comparing(Apple::getWeight).reversed());
		//比较器链
		appleList.sort(Comparator.comparing(Apple::getColor).reversed().thenComparing(Apple::getWeight));

		//谓词复合
		//谓词接口包含三个方法：and\or\negate，可以使用已经有的Predicate来创建更加复杂的谓词
		//好处是：谓词复杂了，lambda表达式就可以写的比较简单，易读了
		Predicate<Apple> redApple = apple -> "red".equals(apple.getColor());
		List<Apple> redAppleList = filter(appleList, redApple);
		System.out.println(redAppleList);
		//不是红苹果
		Predicate<Apple> notRedApple = redApple.negate();
		List<Apple> notRedAppleList = filter(appleList, notRedApple);
		System.out.println(notRedAppleList);
		//红苹果，而且重量超过150g
		Predicate<Apple> andPredicate = redApple.and(apple -> apple.getWeight() > 150);
		List<Apple> andPredicateList = filter(appleList, andPredicate);
		System.out.println(andPredicateList);
		//要么是重150g以上的红苹果，要么是绿苹果
		Predicate<Apple> or = redApple.and(apple -> apple.getWeight() > 150)
				.or(apple -> "green".equals(apple.getColor()));
		List<Apple> result = filter(appleList, or);
		System.out.println(result);

		//函数复合
		//好处是，可以重复利用我们定义好的函数，来拼装成为一个更加复杂的函数，类似于数学中的积分
		//可以把Function接口所代表的Lambda表达式复合起来。 Function接口为此配了andThen和compose两个默认方法，它们都会返回Function的一个实例
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		//andThen: 下面类似于g(f(x))
		Function<Integer, Integer> h = f.andThen(g);
		int function1 = h.apply(1);
		System.out.println(function1);
		//compose: 下面类似于f(g(x))
		Function<Integer, Integer> k = f.compose(g);
		Integer function2 = k.apply(1);
		System.out.println(function2);
	}
}
