package top.hengshare.interview.pattern.command.backCall.version0;

public class PrintService implements Command {

	private Printer printer;

	public PrintService(Printer printer) {
		this.printer = printer;
	}

	@Override
	public void execute() {
		printer.action();
	}
}
