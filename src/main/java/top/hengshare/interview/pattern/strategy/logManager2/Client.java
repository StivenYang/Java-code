package top.hengshare.interview.pattern.strategy.logManager2;

/**
 * @program: Java-Interview
 * @description: 测试模板方法模式结合策略模式
 * @author: Steven Yang
 * @create: 2019-10-16 11:11
 **/
public class Client {
	public static void main(String[] args) {
		LogContext context = new LogContext();
		context.log("记录日志");
		context.log("再次记录日志");
	}
}
