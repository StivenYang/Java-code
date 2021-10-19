package top.hengshare.interview.pattern.command.backCall.version0;

public class Invoker {
	private Command cmd;

	public void setCmd(Command cmd) {
		this.cmd = cmd;
	}

	public void startPrint() {
		this.cmd.execute();
	}
}
