package top.hengshare.interview.generic.simple;

/**
 * @program: Java-Interview
 * @description: TupleTest
 * @author: StivenYang
 * @create: 2019-11-16 13:51
 **/
public class TupleTest {

	static TwoTuple<String, Integer> f() {
		return new TwoTuple<>("hi", 47);
	}

	static ThreeTuple<Object, String, Integer> h() {
		return new ThreeTuple<>(new Object(), "hi", 47);
	}

	public static void main(String[] args) {
		System.out.println(f());
		System.out.println(h());
	}
}
