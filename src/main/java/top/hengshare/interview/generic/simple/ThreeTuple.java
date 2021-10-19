package top.hengshare.interview.generic.simple;

/**
 * @program: Java-Interview
 * @description: TreeTuple
 * @author: StivenYang
 * @create: 2019-11-16 13:46
 **/
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {

	public final C third;

	public ThreeTuple(A first, B second, C third) {
		super(first, second);
		this.third = third;
	}

	@Override
	public String toString() {
		return "(" + first + ", " + second + "," + third + ")";
	}
}
