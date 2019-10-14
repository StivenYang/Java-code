package top.hengshare.interview.pattern.command.example;

public class OpenCommand implements Command {

    private MainBoardAPI mainBoard;

    public OpenCommand(MainBoardAPI mainBoard) {
        this.mainBoard = mainBoard;
    }

    @Override
    public void execute() {
        this.mainBoard.open();
    }
}
