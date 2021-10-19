package top.hengshare.interview.pattern.command.hongCommand;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 菜单宏命令
 */
public class MenuCommand implements Command {

	private List<Command> col = Lists.newArrayList();

	public void addCommand(Command cmd) {
		col.add(cmd);
	}

	@Override
	public void execute() {
		for (Command command : col) {
			command.execute();
		}
	}
}
