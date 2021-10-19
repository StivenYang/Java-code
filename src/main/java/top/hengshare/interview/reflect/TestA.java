package top.hengshare.interview.reflect;

import lombok.Data;

@Data
class TestA {

	private TestB b;

	/**
	 * @return b
	 */
	public TestB getB() {
		return b;
	}
}
