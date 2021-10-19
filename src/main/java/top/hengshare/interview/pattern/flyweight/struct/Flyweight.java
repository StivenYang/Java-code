package top.hengshare.interview.pattern.flyweight.struct;

/**
 * 享元接口，通过这个接口，享元可以接受并作用于外部状态
 */
public interface Flyweight {

	/**
	 * 一些操作，传入外部状态
	 * @param state 示例参数，表示外部状态
	 */
	void operation(String state);
}
