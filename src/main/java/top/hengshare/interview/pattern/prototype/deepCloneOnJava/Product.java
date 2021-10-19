package top.hengshare.interview.pattern.prototype.deepCloneOnJava;

import lombok.Data;

/**
 * 产品对象
 */
@Data
public class Product implements Cloneable {
	/**
	 * 产品编号
	 */
	private String productId;
	/**
	 * 产品名称
	 */
	private String name;

	@Override
	protected Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
