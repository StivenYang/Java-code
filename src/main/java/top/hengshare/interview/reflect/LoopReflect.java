package top.hengshare.interview.reflect;

import com.google.common.collect.Maps;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 循环引用例子 类似于TwoSum
 *
 * @author yangjiaheng
 * @date 2020/9/18 4:20 下午
 **/
public class LoopReflect {

    private static Map<String, Object> cacheMap = Maps.newHashMap();

    public static void main(String[] args) {
        Class[] classes = { TestA.class, TestB.class };

        for (Class aClass : classes) {
            getBean(aClass);
        }

        // check
        System.out.println(getBean(TestB.class).getA() == getBean(TestA.class));
        System.out.println(getBean(TestA.class).getB() == getBean(TestB.class));
    }

    @SneakyThrows
    public static <T> T getBean(Class<T> beanClass) {
        String beanName = beanClass.getSimpleName().toLowerCase();
        // 判断缓存是否有这个bean了，有的话直接返回
        if (cacheMap.containsKey(beanName)) {
            return (T) cacheMap.get(beanName);
        }
        Object object = beanClass.getDeclaredConstructor().newInstance();
        cacheMap.put(beanName, object);
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> fieldClass = field.getType();
            String fieldBeanName = fieldClass.getSimpleName().toLowerCase();
            field.set(object, cacheMap.containsKey(fieldBeanName) ? cacheMap.get(fieldBeanName) : getBean(fieldClass));
        }

        return (T) object;
    }
}

