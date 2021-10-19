package top.hengshare.interview.pattern.command.hongCommand;

public class ChopCommand implements Command {

	private CookAPI cookAPI;

	public void setCookAPI(CookAPI cookAPI) {
		this.cookAPI = cookAPI;
	}

	@Override
	public void execute() {
		cookAPI.cook("绿豆排骨煲");
	}
}
