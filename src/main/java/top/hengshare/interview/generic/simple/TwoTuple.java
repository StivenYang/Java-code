package top.hengshare.interview.generic.simple;

/**
 * @program: Java-Interview
 * @description: 泛型，可以利用这个直接返回两个对象，从而省略创建对象的过程
 * @author: StivenYang
 * @create: 2019-11-16 13:40
 **/
public class TwoTuple<A, B> {
	public final A first;
	public final B second;

	public TwoTuple(A first, B second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "(" + first + ", " + second + ")";
	}
}
