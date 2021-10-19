package top.hengshare.interview.pattern.command.struct;

public class Client {
	public void assemble() {
		//创建接收者
		Receiver receiver = new Receiver();

		//创建命令对象，并设置它的接收者
		ConcreteCommand command = new ConcreteCommand(receiver);
		//创建Invoker，并把命令对象设置进去
		Invoker invoker = new Invoker();
		invoker.setCommand(command);

	}
}
