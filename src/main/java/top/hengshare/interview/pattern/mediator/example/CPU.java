package top.hengshare.interview.pattern.mediator.example;

public class CPU extends Colleague {
	public CPU(Mediator mediator) {
		super(mediator);
	}

	private String videoData = "";

	private String soundData = "";

	public String getVideoData() {
		return videoData;
	}

	public String getSoundData() {
		return soundData;
	}

	public void executeData(String data) {
		//把数据分解开，前面的是视频数据，后面的是音频数据
		String[] ss = data.split("，");
		this.videoData = ss[0];
		this.soundData = ss[1];
		//通知主板，CPU的工作已经完成
		this.getMediator().changed(this);
	}
}
