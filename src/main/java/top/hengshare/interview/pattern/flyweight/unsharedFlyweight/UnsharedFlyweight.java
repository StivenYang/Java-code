package top.hengshare.interview.pattern.flyweight.unsharedFlyweight;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @program: Java-Interview
 * @description: 不需要共享的数据
 * @author: StivenYang
 * @create: 2019-10-22 11:13
 **/
public class UnsharedFlyweight implements Flyweight {

	/**
	 * 保存不被共享的享元对象
	 */
	private List<Flyweight> list = Lists.newArrayList();

	@Override
	public boolean match(String entity, String permit) {
		for (Flyweight flyweight : list) {
			if (flyweight.match(entity, permit)) {
				//如果符合登陆条件，返回true
				return true;
			}
		}
		return false;
	}

	@Override
	public void add(Flyweight flyweight) {
		list.add(flyweight);
	}

	@Override
	public String toString() {
		return "UnsharedFlyweight{" + "list=" + list + '}';
	}
}
