package top.hengshare.interview.pattern.flyweight.unsharedFlyweight;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @program: Java-Interview
 * @description: 享元工厂
 * @author: StivenYang
 * @create: 2019-10-22 13:49
 **/
public class FlyweightFactory {
    private static FlyweightFactory factory = new FlyweightFactory();

    private FlyweightFactory() {
    }

    public static FlyweightFactory getInstance(){
        return factory;
    }

    /**
     * 缓存多个flyweight对象
     */
    private Map<String, Flyweight> fsMap = Maps.newHashMap();

    /**
     * 获取享元
     * @param key 享元对应的key
     * @return 享元对象
     */
    public Flyweight getFlyweight(String key){
        Flyweight flyweight = fsMap.get(key);
        if (flyweight==null){
            flyweight = new AuthFlyweight(key);
            fsMap.put(key, flyweight);
        }
        return flyweight;
    }
}
