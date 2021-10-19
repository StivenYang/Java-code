package top.hengshare.interview.pattern.command.queueCommand;

public class Waiter {

	private MenuCommand menuCommand = new MenuCommand();

	public void orderDish(Command cmd) {
		this.menuCommand.addCommand(cmd);
	}

	public void orderOver() {
		this.menuCommand.execute();
	}
}
