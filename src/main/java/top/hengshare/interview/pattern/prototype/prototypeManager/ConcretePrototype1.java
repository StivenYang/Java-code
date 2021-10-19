package top.hengshare.interview.pattern.prototype.prototypeManager;

public class ConcretePrototype1 implements Prototype {
	private String name;

	@Override
	public Prototype clone() {
		ConcretePrototype1 prototype = new ConcretePrototype1();
		prototype.setName(this.name);
		return prototype;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "现在是原型1的对象，名字为：" + name;
	}
}
