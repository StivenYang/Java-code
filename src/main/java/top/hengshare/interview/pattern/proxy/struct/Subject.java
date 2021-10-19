package top.hengshare.interview.pattern.proxy.struct;

/**
 * 抽象的目标接口，定义具体的目标对象和代理公用的接口
 */
public interface Subject {
	/**
	 * 一个抽象的请求方法
	 */
	void request();
}
