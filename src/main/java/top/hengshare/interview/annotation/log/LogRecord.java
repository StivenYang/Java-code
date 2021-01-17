package top.hengshare.interview.annotation.log;

import top.hengshare.interview.constant.LogActionEnum;

import java.lang.annotation.*;


/**
 * 操作记录留痕
 *
 * @author yjh
 * @since  2021/1/13 12:06 下午
 **/
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogRecord {

    LogActionEnum action() default LogActionEnum.DEFAULT_ACTION;

    String description() default "";
}
