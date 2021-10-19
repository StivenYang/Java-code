package top.hengshare.interview.pattern.prototype.struct;

/**
 * 使用原型的客户端
 */
public class Client {
	/**
	 * 持有需要使用的原型接口对象
	 */
	private Prototype prototype;

	/**
	 * 传入需要使用的原型接口对象
	 * @param prototype
	 */
	public Client(Prototype prototype) {
		this.prototype = prototype;
	}

	/**
	 * 执行某个需要原型对象的操作
	 */
	public void operation() {
		Prototype newPrototype = prototype.clone();
	}
}
