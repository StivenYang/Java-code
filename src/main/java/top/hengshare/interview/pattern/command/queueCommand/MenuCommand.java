package top.hengshare.interview.pattern.command.queueCommand;

import com.google.common.collect.Lists;

import java.util.List;

public class MenuCommand implements Command {

	private List<Command> cmds = Lists.newArrayList();

	public void addCommand(Command command) {
		cmds.add(command);
	}

	public List<Command> getCmds() {
		return cmds;
	}

	@Override
	public void execute() {
		CommandQueue.addMenu(this);
	}

	@Override
	public void setCookAPI(CookAPI cookAPI) {

	}

	@Override
	public int getTblNum() {
		return 0;
	}
}
