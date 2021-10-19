package top.hengshare.interview.pattern.singleton;

public class Singleton {

	/**
	 * 此处的volatile不可以省略，否则会导致线程无序写入导致的失败情况
	 */
	private static volatile Singleton instance = null;

	private Singleton() {
	}

	public static Singleton getInstance() {
		//先检查实例是否存在，不存在才进入下面的同步块
		if (instance == null) {
			//同步块，线程安全的创建实例
			synchronized (Singleton.class) {
				//再次检查实例是否存在，如果不存在，才真正的创建实例
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
