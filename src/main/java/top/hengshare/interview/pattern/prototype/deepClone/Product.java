package top.hengshare.interview.pattern.prototype.deepClone;

import lombok.Data;

/**
 * 产品对象
 */
@Data
public class Product implements ProductPrototype {
	/**
	 * 产品编号
	 */
	private String productId;
	/**
	 * 产品名称
	 */
	private String name;

	@Override
	public ProductPrototype cloneProduct() {
		Product product = new Product();
		product.setName(this.name);
		product.setProductId(this.productId);
		return product;
	}
}
