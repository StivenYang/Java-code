package top.hengshare.interview.pattern.flyweight.gc;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

/**
 * @program: Java-Interview
 * @description: 享元工厂，加入垃圾回收，引用计数的实现
 * @author: StivenYang
 * @create: 2019-10-23 09:46
 **/
public class FlyweightFactory {
    private static FlyweightFactory factory = new FlyweightFactory();

    private FlyweightFactory() {
        //启动清除缓存值的线程
        Thread t = new ClearCache();
        t.start();
    }

    public static FlyweightFactory getInstance(){
        return factory;
    }

    /**
     * 缓存享元对象
     */
    private Map<String, Flyweight> fsMap = Maps.newHashMap();

    /**
     * 用来记录被缓存对象的缓存配置，key值和上面的map对象是一样的
     */
    private Map<String, CacheConfModel> cacheConfModelMap = Maps.newHashMap();

    /**
     * 用来记录缓存对象被引用的次数
     */
    private Map<String, Integer> countMap = Maps.newHashMap();

    /**
     * 默认保存6秒钟，主要为了测试方便
     */
    private final long DURABLE_TIME = 6*1000;

    /**
     * 获取某个享元被使用的次数
     * @param key 享元的key
     * @return 享元被使用的次数
     */
    public synchronized int getUseTimes(String key){
        Integer count = countMap.get(key);
        if (count == null) {
            count = 0;
        }

        return count;
    }

    /**
     * 获取元享数据
     * @param key 元享key
     * @return 元享对象
     */
    public synchronized Flyweight getFlyweight(String key){
        Flyweight flyweight = fsMap.get(key);
        if (flyweight == null) {
            flyweight = new AuthFlyweight(key);
            fsMap.put(key, flyweight);
            //同时设置引用计数
            countMap.put(key, 1);

            //同时设置缓存配置数据
            CacheConfModel confModel = new CacheConfModel();
            confModel.setBeginTime(System.currentTimeMillis());
            confModel.setDurableTime(DURABLE_TIME);
            confModel.setForever(false);
            cacheConfModelMap.put(key, confModel);
        }else {
            //表明还存在与缓存中，只需要取得key，重新设置缓存配置和计数器
            CacheConfModel confModel = cacheConfModelMap.get(key);
            confModel.setBeginTime(System.currentTimeMillis());
            this.cacheConfModelMap.put(key, confModel);
            Integer count = countMap.get(key);
            count++;
            countMap.put(key, count);
        }
        return flyweight;
    }

    /**
     * 删除某个元享对象
     * @param key 要删除的元享对象的key
     */
    private synchronized void removeFlyweight(String key){
        this.fsMap.remove(key);
        this.countMap.remove(key);
        this.cacheConfModelMap.remove(key);
    }

    /**
     * 对象被调用的时候，后台维护一个清除缓存的线程，内部使用
     */
    private class ClearCache extends Thread{
        @Override
        public void run() {
            while (true) {
                Set<String> tempSet = Sets.newHashSet();
                Set<String> sets = cacheConfModelMap.keySet();
                for (String key : sets) {
                    CacheConfModel confModel = cacheConfModelMap.get(key);
                    //判断是否需要清除
                    if (System.currentTimeMillis() - confModel.getBeginTime() >= confModel.getDurableTime()) {
                        //可以清除，先记录下来
                        tempSet.add(key);
                    }
                }
                //真正清除
                for (String set : tempSet) {
                    FlyweightFactory.getInstance().removeFlyweight(set);
                }
                System.out.println("now thread="+fsMap.size()+",fsMap="+fsMap.keySet());
                //休息1s再重新判断
                try {
                    Thread.sleep(3000L);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}