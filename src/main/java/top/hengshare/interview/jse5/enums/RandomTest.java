package top.hengshare.interview.jse5.enums;

/**
 * @program: Java-Interview
 * @description: RandomTest
 * @author: StivenYang
 * @create: 2019-11-21 21:40
 **/
public class RandomTest {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(Enums.random(Activity.class) + " ");
		}
	}
}

enum Activity {
	SITTING, LYING, STANDING, HOPPING, RUNNING, DODGING, JUMPING, FALLING, FLYING
}
