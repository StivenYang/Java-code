package top.hengshare.interview.pattern.mediator.example;

public class CDDriver extends Colleague {
	public CDDriver(Mediator mediator) {
		super(mediator);
	}

	private String data = "";

	public String getData() {
		return data;
	}

	public void readCD() {
		//逗号前是视频数据，逗号后是声音
		this.data = "设计模式，适当研究研究";
		//通知主板，自己的状态发生了变化
		this.getMediator().changed(this);
	}
}
