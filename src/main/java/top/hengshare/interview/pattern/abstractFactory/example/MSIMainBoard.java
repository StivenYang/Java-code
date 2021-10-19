package top.hengshare.interview.pattern.abstractFactory.example;

public class MSIMainBoard implements MainBoardApi {

	private int cpuHoles = 0;

	public MSIMainBoard(int cpuHoles) {
		this.cpuHoles = cpuHoles;
	}

	@Override
	public void installCPU() {
		System.out.println("现在使用的是微星主板，需要cpu针脚数：" + cpuHoles);
	}
}
