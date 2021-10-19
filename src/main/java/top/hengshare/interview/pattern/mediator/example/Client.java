package top.hengshare.interview.pattern.mediator.example;

public class Client {
	public static void main(String[] args) {
		//新建中介者-主板
		MotherBoard motherBoard = new MotherBoard();
		//将cd驱动器和主板绑定
		CDDriver cd = new CDDriver(motherBoard);
		//将cpu和主板绑定
		CPU cpu = new CPU(motherBoard);
		//将显卡和声卡和主板进行绑定
		VideoCard videoCard = new VideoCard(motherBoard);
		SoundCard soundCard = new SoundCard(motherBoard);

		//给主板安装各个部件的驱动器，注册驱动到主板
		motherBoard.setCdDriver(cd);
		motherBoard.setCpu(cpu);
		motherBoard.setSoundCard(soundCard);
		motherBoard.setVideoCard(videoCard);

		//使用cd驱动器开始看电影
		cd.readCD();

	}
}
