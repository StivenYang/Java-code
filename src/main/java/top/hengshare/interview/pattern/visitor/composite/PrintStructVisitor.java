package top.hengshare.interview.pattern.visitor.composite;

/**
 * @program: Java-Interview
 * @description: PrintStructVisitor
 * @author: StivenYang
 * @create: 2019-11-05 19:00
 **/
public class PrintStructVisitor implements Visitor {

	private String preStr = "";

	@Override
	public void visitComposite(Composite composite) {
		//先输出自己
		System.out.println(preStr + "+" + composite.getName());
		//如果还有子组件，就输出子组件
		if (composite.getChildComponents() != null) {
			//然后就添加一个空格，表示缩进
			preStr += "  ";
			for (Component component : composite.getChildComponents()) {
				component.accept(this);
			}
			//把循环子对象多加入的一个退格给去掉
			preStr = preStr.substring(0, preStr.length() - 2);
		}
	}

	@Override
	public void visitLeaf(Leaf leaf) {
		System.out.println(preStr + "-" + leaf.getName());
	}
}
