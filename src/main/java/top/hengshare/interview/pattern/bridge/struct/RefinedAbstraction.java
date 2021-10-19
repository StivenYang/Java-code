package top.hengshare.interview.pattern.bridge.struct;

/**
 * @program: Java-Interview
 * @description: RefinedAbstraction
 * @author: StivenYang
 * @create: 2019-11-02 19:55
 **/
public class RefinedAbstraction extends Abstraction {
	public RefinedAbstraction(Implementor impl) {
		super(impl);
	}

	public void otherOperation() {
		//实现一定的功能，可能会调用具体实现部分的实现方法
		//但是本方法更大的可能是使用Abstraction中定义的方法
		//通过组合使用Abstraction中定义的方法，来实现更多的功能
	}
}
