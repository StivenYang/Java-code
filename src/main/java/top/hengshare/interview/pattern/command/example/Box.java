package top.hengshare.interview.pattern.command.example;

public class Box {

    private Command openCommand;

    private Command resetCommand;

    public void setOpenCommand(Command openCommand) {
        this.openCommand = openCommand;
    }

    public void setResetCommand(Command resetCommand) {
        this.resetCommand = resetCommand;
    }

    public void openButtonPressed(){
        this.openCommand.execute();
    }

    public void resetButtonPressed(){
        this.resetCommand.execute();
    }
}
