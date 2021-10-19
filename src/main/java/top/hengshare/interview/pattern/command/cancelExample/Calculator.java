package top.hengshare.interview.pattern.command.cancelExample;

import com.google.common.collect.Lists;

import java.util.List;

public class Calculator {

	private Command addCmd;

	private Command substractCmd;

	private List<Command> undoList = Lists.newArrayList();

	private List<Command> redoList = Lists.newArrayList();

	public void setAddCmd(Command addCmd) {
		this.addCmd = addCmd;
	}

	public void setSubstractCmd(Command substractCmd) {
		this.substractCmd = substractCmd;
	}

	public void addPressed() {
		addCmd.execute();
		//把操作记录到历史记录里面
		undoList.add(this.addCmd);
	}

	public void substractPressed() {
		substractCmd.execute();
		//把操作记录到历史记录里面
		undoList.add(this.substractCmd);
	}

	public void undoPressed() {
		if (undoList.size() > 0) {
			//取最近执行的一个操作进行撤销
			Command cmd = this.undoList.get(this.undoList.size() - 1);
			cmd.undo();
			redoList.add(cmd);
			//执行完撤销之后，删除该命令
			this.undoList.remove(this.undoList.size() - 1);
		} else {
			System.out.println("抱歉，没有可以撤销的命令了");
		}
	}

	public void redoPressed() {
		if (redoList.size() > 0) {
			Command cmd = this.redoList.get(this.redoList.size() - 1);
			cmd.execute();
			undoList.add(cmd);
			redoList.remove(redoList.size() - 1);
		} else {
			System.out.println("抱歉，没有可以恢复的命令了");
		}
	}
}
