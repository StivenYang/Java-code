package top.hengshare.interview.pattern.singleton;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * java中缓存的实现（没有考虑同步，和缓存的清除）
 */
public class SingletonCache {

	/**
	 * 缓存数据的容器
	 */
	private Map<String, Object> map = Maps.newHashMap();

	public Object getValue(String key) {
		//从缓存里面取值
		Object obj = map.get(key);
		if (obj == null) {
			//如果没有，就到数据库或者文件中去读取数据放到缓存中
			obj = key + ", value";
			//把获取的值设置到map中去
			map.put(key, obj);
		}
		return obj;
	}

	public Object getValueJava8(String key) {
		//同上，但是使用的事java8函数表达式
		return map.computeIfAbsent(key, k -> k + ", value");
	}
}
