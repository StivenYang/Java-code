package top.hengshare.interview.pattern.command.cancelExample;

public class AddCommand implements Command {

	private OperationAPI operation;

	private int num;

	public AddCommand(OperationAPI operation, int num) {
		this.operation = operation;
		this.num = num;
	}

	@Override
	public void execute() {
		operation.add(num);
	}

	@Override
	public void undo() {
		this.operation.substract(num);
	}
}
