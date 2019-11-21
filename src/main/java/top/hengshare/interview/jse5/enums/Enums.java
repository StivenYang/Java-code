package top.hengshare.interview.jse5.enums;

import java.util.Random;

/**
 * @program: Java-Interview
 * @description: 随机选取
 * @author: StivenYang
 * @create: 2019-11-21 21:33
 **/
public class Enums {

    private static Random rand = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
