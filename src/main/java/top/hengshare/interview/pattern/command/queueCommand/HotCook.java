package top.hengshare.interview.pattern.command.queueCommand;

public class HotCook implements CookAPI, Runnable {

	private String name;

	public HotCook(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			Command cmd = CommandQueue.getOneCommand();
			if (cmd != null) {
				cmd.setCookAPI(this);
				cmd.execute();
			}
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void cook(int tblNum, String name) {
		int cookTime = (int) (20 * Math.random());
		System.out.println(this.name + "厨师正在给" + tblNum + "桌做：" + name);
		try {
			Thread.sleep(cookTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(this.name + "厨师为" + tblNum + "桌做的：" + name + "已经做好了,总共耗时：" + cookTime + "秒");
	}
}
