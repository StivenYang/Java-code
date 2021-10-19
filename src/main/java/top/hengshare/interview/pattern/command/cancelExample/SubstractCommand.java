package top.hengshare.interview.pattern.command.cancelExample;

public class SubstractCommand implements Command {

	private OperationAPI operation;

	private int num;

	public SubstractCommand(OperationAPI operation, int num) {
		this.operation = operation;
		this.num = num;
	}

	@Override
	public void execute() {
		operation.substract(num);
	}

	@Override
	public void undo() {
		this.operation.add(num);
	}
}
