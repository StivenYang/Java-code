package top.hengshare.interview.pattern.command.logCommand;

public interface Command {
	void execute();

	void setCookAPI(CookAPI cookAPI);

	int getTblNum();
}
