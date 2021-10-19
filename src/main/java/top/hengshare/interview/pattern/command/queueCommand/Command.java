package top.hengshare.interview.pattern.command.queueCommand;

public interface Command {
	void execute();

	void setCookAPI(CookAPI cookAPI);

	int getTblNum();
}
