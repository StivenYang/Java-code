package top.hengshare.interview.pattern.simpleFactory;

/**
 * 游客，参观动物园
 */
public class Tourist {
	public static void main(String[] args) {
		ZooFactory zooFactory = new ZooFactory();
		Dog dog = (Dog) zooFactory.seeAnimal(1);
		dog.eat();
		dog.sleep();
		Animal animal = zooFactory.seeAnimal(2);
		animal.eat();
		animal.sleep();
	}

}
