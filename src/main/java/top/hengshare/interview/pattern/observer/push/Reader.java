package top.hengshare.interview.pattern.observer.push;

public class Reader implements Observer {

	private String name;

	@Override
	public void update(String content) {
		System.out.println(name + "收到推送消息：" + content);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
