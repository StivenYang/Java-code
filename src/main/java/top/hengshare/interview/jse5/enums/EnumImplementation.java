package top.hengshare.interview.jse5.enums;

import top.hengshare.interview.generic.simple.interfaces.Generator;

import java.util.Random;

/**
 * @program: Java-Interview
 * @description: 枚举不能继承，但是可以实现接口
 * @author: StivenYang
 * @create: 2019-11-21 21:13
 **/
public class EnumImplementation {
	private static <T> void printNext(Generator<T> rg) {
		System.out.println(rg.next() + ", ");
	}

	public static void main(String[] args) {
		CartoonCharacter cc = CartoonCharacter.BOB;
		for (int i = 0; i < 10; i++) {
			printNext(cc);
		}
	}
}

enum CartoonCharacter implements Generator<CartoonCharacter> {
	SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
	private Random rand = new Random(47);

	public CartoonCharacter next() {
		return values()[rand.nextInt(values().length)];
	}
}