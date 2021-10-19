package top.hengshare.interview.pattern.proxy.jdkproxy;

public interface UserService {
	/**
	 * 目标方法，增加的时候需要使用动态代理来增强
	 */
	void add();

	/**
	 * 目标方法，删除
	 */
	void delete();
}
