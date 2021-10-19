package top.hengshare.interview.pattern.strategy.logManager2;

import java.time.LocalDateTime;

/**
 * @program: Java-Interview
 * @description: 日志策略模板
 * @author: Steven Yang
 * @create: 2019-10-16 11:04
 **/
public abstract class LogStrategyTemplate implements LogStrategy {
	public final void log(String msg) {
		//为日志添加时间
		msg = LocalDateTime.now().toString() + " ：" + msg;
		doLog(msg);
	}

	/**
	 * 真正的记录日志，交给子类算法去执行
	 * @param msg 日志
	 */
	protected abstract void doLog(String msg);
}
