package top.hengshare.interview.pattern.visitor.struct;

/**
 * @program: Java-Interview
 * @description: Client
 * @author: StivenYang
 * @create: 2019-11-03 18:29
 **/
public class Client {
	public static void main(String[] args) {
		//创建ObjectStructure
		ObjectStructure structure = new ObjectStructure();
		//创建要加入对象结构的元素
		ConcreteElementA elementA = new ConcreteElementA();
		ConcreteElementB elementB = new ConcreteElementB();
		//加入到structure
		structure.addElement(elementA);
		structure.addElement(elementB);
		//创建访问者
		ConcreteVisitorA visitorA = new ConcreteVisitorA();
		//调用业务处理的方法
		structure.handleRequest(visitorA);
	}
}
