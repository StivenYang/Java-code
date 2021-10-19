package top.hengshare.interview.pattern.visitor.composite;

/**
 * @program: Java-Interview
 * @description: Visitor
 * @author: StivenYang
 * @create: 2019-11-05 16:05
 **/
public interface Visitor {

	void visitComposite(Composite composite);

	void visitLeaf(Leaf leaf);
}
