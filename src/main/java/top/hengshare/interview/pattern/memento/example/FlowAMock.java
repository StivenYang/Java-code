package top.hengshare.interview.pattern.memento.example;

import lombok.Data;

/**
 * @program: Java-Interview
 * @description: 模拟运行流程A
 * @author: Steven Yang
 * @create: 2019-10-18 10:16
 **/
@Data
public class FlowAMock {
	/**
	 * 流程名称
	 */
	private String flowName;

	/**
	 * 代指某个中间结果
	 */
	private int tempResult;

	/**
	 * 代指某个中间状态
	 */
	private String tempState;

	public FlowAMock(String flowName) {
		this.flowName = flowName;
	}

	/**
	 * 运行第一个流程
	 */
	public void runPhaseOne() {
		tempResult = 3;
		tempState = "PhaseOne";
	}

	/**
	 * 按照方案一来运行流程后半部分
	 */
	public void schema1() {
		this.tempState += ", schema1";
		System.out.println(this.tempState + " : now run " + tempResult);
		this.tempResult += 11;
	}

	/**
	 * 按照方案二来运行流程后半部分
	 */
	public void schema2() {
		this.tempState += ", schema2";
		System.out.println(this.tempState + " : now run " + tempResult);
		this.tempResult += 22;
	}
}
