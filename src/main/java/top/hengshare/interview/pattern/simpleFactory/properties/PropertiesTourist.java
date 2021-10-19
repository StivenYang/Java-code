package top.hengshare.interview.pattern.simpleFactory.properties;

import top.hengshare.interview.pattern.simpleFactory.Animal;

public class PropertiesTourist {
	public static void main(String[] args) {
		Animal dog = PropertiesFactory.seeAnimal(1);
		dog.sleep();
		dog.eat();
		Animal cat = PropertiesFactory.seeAnimal(2);
		cat.sleep();
		cat.eat();
	}
}
