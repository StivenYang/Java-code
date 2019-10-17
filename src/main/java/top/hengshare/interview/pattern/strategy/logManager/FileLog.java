package top.hengshare.interview.pattern.strategy.logManager;

/**
 * @program: Java-Interview
 * @description: 记录日志到文件
 * @author: Steven Yang
 * @create: 2019-10-16 10:16
 **/
public class FileLog implements LogStrategy {
    @Override
    public void log(String msg) {
        System.out.println("现在把'" + msg + "'记录到文件");
    }
}
