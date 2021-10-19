package top.hengshare.interview.pattern.builder.example;

/**
 * 具体的生成器实现对象
 */
public class ConcreteBuilder implements Builder {

	private Product resultProduct;

	@Override
	public void buildPart() {

	}

	public Product getResultProduct() {
		return resultProduct;
	}
}
