package top.hengshare.interview.java8.lambda;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

/**
 * @author StivenYang
 * @program interview
 * @description Java8实战第一章实战代码
 * @date 2019-07-22 23:55
 **/
public class Practice01 {
	public static void main(String[] args) {
		List<Apple> appleList = Lists.newArrayList();
		Apple green = new Apple("green");
		green.setWeight(2D);
		appleList.add(green);
		Apple red = new Apple("red");
		red.setWeight(3D);
		appleList.add(red);

		//第一步：传递代码
		appleList.sort(new AppleComparator());
		System.out.println(appleList);
		//第二步：使用匿名类
		appleList.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
		});
		System.out.println(appleList);
		//第三部：使用lambda表达式
		appleList.sort((Apple o1, Apple o2) -> o1.getWeight().compareTo(o2.getWeight()));
		System.out.println(appleList);
		//因为jvm可以根据lambda上下文来推断lambda表达式的参数类型，所以还可以简化为下面这种写法
		appleList.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
		System.out.println(appleList);
		//又因为java8的comparator接口中有comparing静态方法，它可以像下面这样用：
		appleList.sort(Comparator.comparing((apple -> apple.getWeight())));
		System.out.println(appleList);
		//第四步：使用方法引用
		appleList.sort(Comparator.comparing(Apple::getWeight));
		System.out.println(appleList);
	}
}

class AppleComparator implements Comparator<Apple> {
	@Override
	public int compare(Apple a1, Apple a2) {
		return a1.getWeight().compareTo(a2.getWeight());
	}
}
