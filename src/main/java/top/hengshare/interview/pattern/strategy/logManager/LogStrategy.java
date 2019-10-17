package top.hengshare.interview.pattern.strategy.logManager;

/**
 * @program: Java-Interview
 * @description: 日志策略
 * @author: Steven Yang
 * @create: 2019-10-16 10:14
 **/
public interface LogStrategy {
    /**
     * 记录日志
     * @param msg 日志信息
     */
    void log(String msg);
}
