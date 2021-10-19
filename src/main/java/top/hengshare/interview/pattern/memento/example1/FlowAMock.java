package top.hengshare.interview.pattern.memento.example1;

public class FlowAMock {

	private String flowName;

	private int tempResult;

	private String tempState;

	public FlowAMock(String flowName) {
		this.flowName = flowName;
	}

	public void runPhaseOne() {
		tempResult = 3;
		tempState = "PhaseOne";
	}

	public void schema1() {

	}
}
