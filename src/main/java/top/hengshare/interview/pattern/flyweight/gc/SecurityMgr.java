package top.hengshare.interview.pattern.flyweight.gc;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;

/**
 * @program: Java-Interview
 * @description: 安全管理
 * @author: StivenYang
 * @create: 2019-10-22 14:08
 **/
public class SecurityMgr {

	/**
	 * 单例化安全管理类
	 */
	private static SecurityMgr securityMgr = new SecurityMgr();

	/**
	 * 禁止new对象
	 */
	private SecurityMgr() {
	}

	/**
	 * 获取单例对象
	 * @return 安全管理对象
	 */
	public static SecurityMgr getInstance() {
		return securityMgr;
	}

	/**
	 * 对享元数据组合进行缓存,相当于web开发中的session
	 */
	private Map<String, Collection<Flyweight>> map = Maps.newHashMap();

	/**
	 * 判断用户是否有权限登陆
	 * @param user 用户名
	 * @param securityEntity 安全对象实体
	 * @param permit 权限
	 * @return 是否有权限登陆
	 */
	public boolean hasPermit(String user, String securityEntity, String permit) {
		Collection<Flyweight> flyweights = this.queryUser(user);
		System.out.println("现在测试" + securityEntity + "的" + permit + "权限，map.size=" + map.size());
		if (flyweights.isEmpty()) {
			System.out.println(user + "没有登陆，或者是没有被分配任何权限");
			return false;
		}
		for (Flyweight flyweight : flyweights) {
			if (flyweight.match(securityEntity, permit)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 查询用户权限信息，如果登陆了，他的权限信息就会存在于缓存中，否则缓存中不存在
	 * @param user 用户名
	 * @return 用户权限享元信息数组
	 */
	private Collection<Flyweight> queryUser(String user) {
		Collection<Flyweight> lists = Lists.newArrayList();
		for (String s : TestDB.colDB) {
			String[] split = s.split(",");
			if (split[0].equals(user)) {
				Flyweight fm = null;
				//如果是非共享享元组合
				if ("2".equals(split[3])) {
					//fm是非共享享元组合
					fm = new UnsharedFlyweight();
					//获取需要组合的数据
					String[] tempstr = TestDB.mapDB.get(split[1]);
					//组合非共享享元和共享享元
					for (String s1 : tempstr) {
						//获取非共享享元数据
						Flyweight flyweight = FlyweightFactory.getInstance().getFlyweight(s1);
						//向享元对象中添加非共享享元对象
						fm.add(flyweight);
					}
				} else {
					//获取享元对象
					fm = FlyweightFactory.getInstance().getFlyweight(split[1] + "," + split[2]);
				}
				lists.add(fm);
			}
		}
		return lists;
	}
}
