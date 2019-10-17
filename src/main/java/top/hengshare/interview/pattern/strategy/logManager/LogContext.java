package top.hengshare.interview.pattern.strategy.logManager;

/**
 * @program: Java-Interview
 * @description: 日志上下文，用来自动切换日志记录策略
 * @author: Steven Yang
 * @create: 2019-10-16 10:17
 **/
public class LogContext {

    public void log(String msg){
        try {
            new DBLog().log(msg);
        }catch (Exception e){
            new FileLog().log(msg);
        }
    }
}
