package top.hengshare.interview.pattern.abstractFactory.example;

public class Schema2 implements AbstractFactory {
	@Override
	public CpuAPI createCPU() {
		return new AMDCPU(939);
	}

	@Override
	public MainBoardApi createMainBoard() {
		return new MSIMainBoard(939);
	}
}
