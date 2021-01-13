package top.hengshare.interview.annotation.checkpassword;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * UseCase 统计使用次数
 *
 * @author StevenYang
 * @date  2020/7/14
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    int id();

    String description() default "no description";
}
