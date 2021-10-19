package top.hengshare.interview.pattern.visitor.struct;

/**
 * @program: Java-Interview
 * @description: Element
 * @author: StivenYang
 * @create: 2019-11-03 18:19
 **/
public abstract class Element {
	/**
	 * 接收访问者的访问
	 * @param visitor
	 */
	public abstract void accept(Visitor visitor);
}
