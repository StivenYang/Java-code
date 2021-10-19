package top.hengshare.interview.pattern.visitor.struct;

/**
 * @program: Java-Interview
 * @description: ConcreteElementA
 * @author: StivenYang
 * @create: 2019-11-03 18:20
 **/
public class ConcreteElementA extends Element {
	@Override
	public void accept(Visitor visitor) {
		visitor.visitConcreteElementA(this);
	}

	public void operationA() {
		//已有的实现的功能
	}
}
