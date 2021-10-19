package top.hengshare.interview.pattern.command.cancelExample;

public class Client {
	public static void main(String[] args) {
		//组件命令和接收者
		//创建接收者
		Operation operation = new Operation();
		//创建命令对象
		AddCommand addCommand = new AddCommand(operation, 5);
		SubstractCommand substractCommand = new SubstractCommand(operation, 3);

		//绑定命令到计算器上
		Calculator calculator = new Calculator();
		calculator.setAddCmd(addCommand);
		calculator.setSubstractCmd(substractCommand);

		//模拟按下按钮
		calculator.addPressed();
		System.out.println("一次加法运算结果：" + operation.getResult());
		calculator.substractPressed();
		System.out.println("一次减法运算结果：" + operation.getResult());

		//测试撤销按钮
		calculator.undoPressed();
		System.out.println("撤销一次：" + operation.getResult());

		//测试恢复按钮
		calculator.redoPressed();
		System.out.println("恢复一次：" + operation.getResult());


	}
}
