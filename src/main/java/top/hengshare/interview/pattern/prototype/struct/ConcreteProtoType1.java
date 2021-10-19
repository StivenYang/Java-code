package top.hengshare.interview.pattern.prototype.struct;

/**
 * 克隆的具体实现对象
 */
public class ConcreteProtoType1 implements Prototype {

	@Override
	public Prototype clone() {
		//最简单的克隆，新建一个自身的对象
		return new ConcreteProtoType1();
	}
}
