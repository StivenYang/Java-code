package top.hengshare.interview.generic.simple.interfaces;

import java.util.Iterator;

/**
 * @program: Java-Interview
 * @description: IteratbleFibonacci
 * @author: StivenYang
 * @create: 2019-11-17 15:27
 **/
public class IteratbleFibonacci extends Fibonacci implements Iterable<Integer> {
	private int n;

	public IteratbleFibonacci(int count) {
		n = count;
	}

	@Override
	public Iterator iterator() {
		return new Iterator() {
			@Override
			public boolean hasNext() {
				return n > 0;
			}

			@Override
			public Object next() {
				n--;
				return IteratbleFibonacci.this.next();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	public static void main(String[] args) {
		for (int i : new IteratbleFibonacci(18)) {
			System.out.println(i + " ");
		}
	}
}
