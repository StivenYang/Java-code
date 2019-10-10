package top.hengshare.interview.pattern.prototype.prototypeManager;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * 原型管理器
 */
public class PrototypeManager {
    /**
     * 用来记录原型名称和原型实例的对应关系
     */
    private static Map<String, Prototype> map = Maps.newHashMap();

    /**
     * 私有化构造方法，避免外部无谓的创建管理器的实例
     */
    private PrototypeManager() {
    }

    /**
     * 向原型管理器中新增或者修改某个原型对象
     *
     * @param prototypeId
     * @param prototype
     */
    public synchronized static void setPrototype(String prototypeId, Prototype prototype) {
        map.put(prototypeId, prototype);
    }

    /**
     * 根据原型编码删除管理器中对应的原型实例
     *
     * @param prototypeId
     */
    public synchronized static void removePrototype(String prototypeId) {
        map.remove(prototypeId);
    }

    /**
     * 获取管理器中的某个原型实例
     * @param prototypeId
     * @return
     */
    public synchronized static Prototype getPrototype(String prototypeId) throws Exception {
        Prototype prototype = map.get(prototypeId);
        if (prototype == null) {
            throw new Exception("要获取的原型对象未注册或者已被销毁!");
        }
        return prototype;
    }
}
