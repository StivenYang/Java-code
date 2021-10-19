package top.hengshare.interview.pattern.observer.pull;

public class Reader implements Observer {

	private String name;

	@Override
	public void update(Subject subject) {
		//采用拉的方式
		System.out.println(name + "收到了报纸，内容是:" + ((Newspaper) subject).getContent());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
