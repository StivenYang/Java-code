package top.hengshare.interview.pattern.command.example;

public class GigaMainBoard implements MainBoardAPI {

	@Override
	public void open() {
		System.out.println("技嘉主板正在开机，请稍等。。。");
		System.out.println("接通电源。。。");
		System.out.println("设备检查。。。");
		System.out.println("装载系统。。。");
		System.out.println("机器正常运转中。。。");
		System.out.println("机器正常启动，开始工作！");
	}

	@Override
	public void reset() {
		System.out.println("技嘉主板正在执行重启命令，请稍等。。。");
		System.out.println("机器已经正常打开，请操作");
	}
}
