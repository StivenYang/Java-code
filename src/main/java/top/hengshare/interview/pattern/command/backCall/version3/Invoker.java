package top.hengshare.interview.pattern.command.backCall.version3;

public class Invoker {

	public void startPrint(Command cmd) {
		cmd.execute();
	}
}
