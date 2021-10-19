package top.hengshare.interview.generic.simple.method;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java-Interview
 * @description: 可变参数与泛型方法
 * @author: StivenYang
 * @create: 2019-11-17 16:38
 **/
public class GenericVarargs {
	public static <T> List<T> makeList(T... args) {
		List<T> result = new ArrayList<T>();
		for (T arg : args) {
			result.add(arg);
		}
		return result;
	}

	public static void main(String[] args) {
		List<String> ls = makeList("A");
		System.out.println(ls);

		ls = makeList("A", "B", "C");
		System.out.println(ls);

		ls = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
		System.out.println(ls);
	}
}
