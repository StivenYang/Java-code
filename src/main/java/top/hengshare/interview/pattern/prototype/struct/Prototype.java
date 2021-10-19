package top.hengshare.interview.pattern.prototype.struct;

/**
 * 声明一个克隆自身的接口
 */
public interface Prototype {
	/**
	 * 克隆自身的方法
	 * @return 一个自身克隆出来的对象
	 */
	Prototype clone();
}
