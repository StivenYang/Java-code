package top.hengshare.interview.pattern.strategy.logManager;

/**
 * @program: Java-Interview
 * @description: 测试容错机制：异常切换日志记录模式
 * @author: Steven Yang
 * @create: 2019-10-16 10:20
 **/
public class Client {
	public static void main(String[] args) {
		LogContext context = new LogContext();
		context.log("记录日志");
		context.log("再次记录日志");
	}
}
