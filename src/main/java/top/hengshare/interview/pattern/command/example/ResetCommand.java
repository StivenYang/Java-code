package top.hengshare.interview.pattern.command.example;

public class ResetCommand implements Command {

	private MainBoardAPI mainBoard;

	public ResetCommand(MainBoardAPI mainBoard) {
		this.mainBoard = mainBoard;
	}

	@Override
	public void execute() {
		mainBoard.reset();
	}
}
