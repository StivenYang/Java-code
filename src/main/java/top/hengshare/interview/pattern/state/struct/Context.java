package top.hengshare.interview.pattern.state.struct;

import lombok.Setter;

/**
 * @program: Java-Interview
 * @description: 状态容器
 * @author: Steven Yang
 * @create: 2019-10-16 14:03
 **/
public class Context {

	@Setter
	private State state;

	public void request(String sampleParameter) {
		this.state.handle(sampleParameter);
	}
}
