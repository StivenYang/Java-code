package top.hengshare.interview.generic.simple.interfaces;

/**
 * @author StivenYang
 **/
public class Coffee {
	private static long counter = 0;
	private final long id = counter++;

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + id;
	}
}

class Latte extends Coffee {
}

class Mocha extends Coffee {
}

class Cappuccino extends Coffee {
}

class Americano extends Coffee {
}

class Breve extends Coffee {
}