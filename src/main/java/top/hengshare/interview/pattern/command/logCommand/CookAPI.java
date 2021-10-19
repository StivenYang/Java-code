package top.hengshare.interview.pattern.command.logCommand;

public interface CookAPI {
	/**
	 * 烹饪
	 * @param tblNum 桌号
	 * @param name 菜名
	 */
	void cook(int tblNum, String name);
}
