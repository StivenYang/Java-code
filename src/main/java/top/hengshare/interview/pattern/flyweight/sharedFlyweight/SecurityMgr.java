package top.hengshare.interview.pattern.flyweight.sharedFlyweight;

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
    private static SecurityMgr securityMgr = new SecurityMgr();

    private SecurityMgr() {
    }

    public static SecurityMgr getInstance(){
        return securityMgr;
    }

    private Map<String, Collection<Flyweight>> map = Maps.newHashMap();

    public void login(String user){
        //查得用户所有的权限
        Collection<Flyweight> flyweights = queryUser(user);
        //放入缓存里面
        map.put(user, flyweights);
    }

    /**
     * 判断用户是否有权限登陆
     * @param user 用户名
     * @param securityEntity 安全对象实体
     * @param permit 权限
     * @return 是否有权限登陆
     */
    public boolean hasPermit(String user, String securityEntity, String permit){
        Collection<Flyweight> flyweights = map.get(user);
        if (flyweights==null || flyweights.isEmpty()) {
            System.out.println(user + "没有登陆，或者是没有被分配任何权限");
            return false;
        }
        for (Flyweight flyweight : flyweights) {
            System.out.println("fm=="+flyweight);
            if (flyweight.match(securityEntity, permit)) {
                return true;
            }
        }
        return false;
    }

    private Collection<Flyweight> queryUser(String user) {
        Collection<Flyweight> lists = Lists.newArrayList();
        for (String s : TestDB.colDB) {
            String[] split = s.split(",");
            if (split[0].equals(user)) {
                Flyweight flyweight = FlyweightFactory.getInstance().getFlyweight(split[1] + "," + split[2]);
                lists.add(flyweight);
            }
        }
        return lists;
    }
}
