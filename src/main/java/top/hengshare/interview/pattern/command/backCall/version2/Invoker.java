package top.hengshare.interview.pattern.command.backCall.version2;

public class Invoker {

	public void startPrint(Command cmd) {
		System.out.println("在invoker中，打印服务前");
		cmd.execute();
		System.out.println("在invoker中，打印服务后");
	}
}
