package top.hengshare.interview.pattern.flyweight.struct;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @program: Java-Interview
 * @description: 享元工厂
 * @author: StivenYang
 * @create: 2019-10-22 11:34
 **/
public class FlyweightFactory {

    /**
     * 获取多个flyweight对象
     */
    private Map<String, Flyweight> fsMap = Maps.newHashMap();

    public Flyweight getFlyweight(String key){
        //1. 从缓存中取出key对应的享元
        Flyweight flyweight = fsMap.get(key);
        //2. 如果享元存在，返回相应的享元对象
        if (flyweight == null) {
            //3. 如果不存在，创建一个新的flyweight对象，
            flyweight = new ConcreteFlyweight(key);
            //4. 把新的flyweight添加到缓存中
            fsMap.put(key, flyweight);
        }
        return flyweight;
        //5. 返回这个新的对象
    }
}
