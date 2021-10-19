package top.hengshare.interview.pattern.proxy.struct;

public class Proxy implements Subject {
	/**
	 * 持有被代理的目标对象
	 */
	private RealSubject realSubject;

	public Proxy(RealSubject realSubject) {
		this.realSubject = realSubject;
	}

	@Override
	public void request() {
		//在转掉具体的目标对象之前，可以执行一些功能处理

		//转掉具体的目标对象的方法
		realSubject.request();

		//在调用完成后，可以执行一些处理功能

	}
}
