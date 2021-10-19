package top.hengshare.interview.pattern.flyweight.struct;

/**
 * @program: Java-Interview
 * @description: 不需要共享的数据
 * @author: StivenYang
 * @create: 2019-10-22 11:13
 **/
public class UnsharedFlyweight implements Flyweight {

	/**
	 * 保存的所有状态
	 */
	private String allState;

	@Override
	public void operation(String state) {

	}
}
