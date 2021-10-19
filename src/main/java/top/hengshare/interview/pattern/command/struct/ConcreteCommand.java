package top.hengshare.interview.pattern.command.struct;

public class ConcreteCommand implements Command {

	private Receiver receiver;

	private String state;

	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.action();
	}
}
