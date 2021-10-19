package top.hengshare.interview.pattern.abstractFactory.example;

public class ComputerEngineer {

	CpuAPI cpu = null;

	MainBoardApi mainBoard = null;

	public void makeComputer(AbstractFactory schema) {
		//1. 准备电脑配件
		prepareHardwares(schema);
		//2. 组装
		//3. 测试
		//4. 交付

	}

	private void prepareHardwares(AbstractFactory schema) {
		this.cpu = schema.createCPU();
		this.mainBoard = schema.createMainBoard();

		this.cpu.calculate();
		this.mainBoard.installCPU();
	}
}
