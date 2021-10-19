package top.hengshare.interview.pattern.flyweight.gc;

import lombok.Data;

/**
 * @program: Java-Interview
 * @description: 缓存配置实体
 * @author: StivenYang
 * @create: 2019-10-23 09:21
 **/
@Data
public class CacheConfModel {
	/**
	 * 缓存开始时间
	 */
	private long beginTime;

	/**
	 * 缓存持续时间
	 */
	private double durableTime;

	/**
	 * 缓存对象需要被永久删除
	 */
	private boolean forever;
}
