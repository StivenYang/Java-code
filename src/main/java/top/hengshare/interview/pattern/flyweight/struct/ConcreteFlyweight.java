package top.hengshare.interview.pattern.flyweight.struct;

/**
 * @program: Java-Interview
 * @description: 享元对象
 * @author: StivenYang
 * @create: 2019-10-22 10:28
 **/
public class ConcreteFlyweight implements Flyweight {

	/**
	 * 描述内部状态
	 */
	private String state;

	/**
	 * 设置内部状态
	 * @param state 内部状态
	 */
	public ConcreteFlyweight(String state) {
		this.state = state;
	}

	/**
	 * 享元具体的处理功能，可能会用到状态
	 * @param state 示例参数，表示外部状态
	 */
	@Override
	public void operation(String state) {

	}

}
