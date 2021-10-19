package top.hengshare.interview.pattern.builder.example;

public class Director {

	private Builder builder;

	public Director(Builder builder) {
		this.builder = builder;
	}

	public void construct() {
		this.builder.buildPart();
	}
}
