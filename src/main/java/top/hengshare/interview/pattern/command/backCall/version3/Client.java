package top.hengshare.interview.pattern.command.backCall.version3;

public class Client {
	public static void main(String[] args) {
		Command cmd = new Command() {
			private String str = "";

			@Override
			public void execute() {
				System.out.println("打印：" + str);
			}

			@Override
			public void setStr(String str) {
				this.str = str;
			}
		};
		cmd.setStr("退化命令模式3");

		Invoker invoker = new Invoker();
		invoker.startPrint(cmd);
	}
}
