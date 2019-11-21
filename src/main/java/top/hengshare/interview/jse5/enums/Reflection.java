package top.hengshare.interview.jse5.enums;

import com.google.common.collect.Sets;
import top.hengshare.interview.utils.net.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * @program: Java-Interview
 * @description: Reflection
 * @author: StivenYang
 * @create: 2019-11-21 16:34
 **/
public class Reflection {
    public static Set<String> analyze(Class<?> enumClass){
        System.out.println("-------正在分析：" + enumClass + "---------");
        System.out.println("接口：");
        for (Type type : enumClass.getInterfaces()) {
            System.out.println(type);
        }
        System.out.println("基类：" + enumClass.getSuperclass());
        System.out.println("方法：");
        Set<String> methods = Sets.newTreeSet();
        for (Method method : enumClass.getMethods()) {
            methods.add(method.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> EnumMethods = analyze(Enum.class);
        System.out.println("explore是否包含所有的Enum方法？ " + exploreMethods.containsAll(EnumMethods));
        System.out.println("explore删除enum的方法之后：");
        exploreMethods.removeAll(EnumMethods);
        System.out.println(exploreMethods);
        OSExecute.command("javap /home/yang/Desktop/Java-Interview/target/classes/top/hengshare/interview/jse5/enums/Explore.class");
    }
}

enum Explore{
    HERE, THERE
}
