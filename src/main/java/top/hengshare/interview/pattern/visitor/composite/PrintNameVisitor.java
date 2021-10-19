package top.hengshare.interview.pattern.visitor.composite;

/**
 * @program: Java-Interview
 * @description: PrintNameVisitor
 * @author: StivenYang
 * @create: 2019-11-05 16:17
 **/
public class PrintNameVisitor implements Visitor {
	@Override
	public void visitComposite(Composite composite) {
		System.out.println("节点：" + composite.getName());
	}

	@Override
	public void visitLeaf(Leaf leaf) {
		System.out.println("节点：" + leaf.getName());
	}
}
