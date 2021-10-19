package top.hengshare.interview.pattern.singleton;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 使用缓存来实现单例（没有考虑同步和缓存的清除）根据上面的同步知识可以自己加上
 */
public class CacheSingleton {
	/**
	 * 定义一个默认的key，标识缓存中的单例
	 */
	private final static String DEFAULT_KEY = "one";

	/**
	 * 缓存实例的容器
	 */
	private static Map<String, CacheSingleton> map = Maps.newHashMap();

	private CacheSingleton() {
	}

	public CacheSingleton getInstance() {
		//获取实例
		CacheSingleton singleton = map.get(DEFAULT_KEY);
		if (singleton == null) {
			singleton = new CacheSingleton();
			map.put(DEFAULT_KEY, singleton);
		}
		return singleton;
	}

}
