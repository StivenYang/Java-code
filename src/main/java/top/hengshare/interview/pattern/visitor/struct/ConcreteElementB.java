package top.hengshare.interview.pattern.visitor.struct;

/**
 * @program: Java-Interview
 * @description: ConcreteElementB
 * @author: StivenYang
 * @create: 2019-11-03 18:21
 **/
public class ConcreteElementB extends Element {
	@Override
	public void accept(Visitor visitor) {
		visitor.visitConcreteElementB(this);
	}

	public void operationB() {
		//已有的实现的功能
	}
}
