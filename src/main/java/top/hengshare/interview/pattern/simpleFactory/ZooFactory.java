package top.hengshare.interview.pattern.simpleFactory;

/**
 * 动物园，可以让游客看动物
 */
public class ZooFactory {
	public Animal seeAnimal(int code) {
		if (code == 1) {
			return new Dog();
		} else {
			return new Cat();
		}
	}
}
