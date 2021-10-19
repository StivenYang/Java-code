package top.hengshare.interview.pattern.command.example;

public class Client {
	public static void main(String[] args) {
		GigaMainBoard gigaMainBoard = new GigaMainBoard();
		OpenCommand openCommand = new OpenCommand(gigaMainBoard);
		ResetCommand resetCommand = new ResetCommand(gigaMainBoard);

		Box box = new Box();
		box.setOpenCommand(openCommand);
		box.setResetCommand(resetCommand);

		System.out.println("按下开机按钮==============》");
		box.openButtonPressed();
		System.out.println("按下重启按钮==============》");
		box.resetButtonPressed();
	}
}
