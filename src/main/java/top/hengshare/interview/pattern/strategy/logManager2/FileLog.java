package top.hengshare.interview.pattern.strategy.logManager2;

/**
 * @program: Java-Interview
 * @description: 记录日志到文件
 * @author: Steven Yang
 * @create: 2019-10-16 10:16
 **/
public class FileLog extends LogStrategyTemplate {

	@Override
	protected void doLog(String msg) {
		System.out.println(msg + "'记录到文件");
	}
}
