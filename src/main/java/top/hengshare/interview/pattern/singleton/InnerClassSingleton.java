package top.hengshare.interview.pattern.singleton;

public class InnerClassSingleton {
	/**
	 * 类级的内部类，只有在第一次被使用的时候才会被装载
	 */
	private static class SingletonHolder {
		/**
		 * 静态初始化器，由jvm来保证线程安全
		 */
		private static InnerClassSingleton instance = new InnerClassSingleton();
	}

	/**
	 * 私有化构造方法
	 */
	private InnerClassSingleton() {
	}

	public static InnerClassSingleton getInstance() {
		return SingletonHolder.instance;
	}
}
