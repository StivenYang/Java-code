package top.hengshare.interview.pattern.command.hongCommand;

/**
 * 凉菜厨师
 */
public class CoolCook implements CookAPI {
	@Override
	public void cook(String name) {
		System.out.println("正在做凉菜:" + name);
	}
}
