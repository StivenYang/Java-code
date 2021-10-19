package top.hengshare.interview.pattern.adapter.used;

public class Adapter implements Target {
	private Adapee adapee;

	public Adapter(Adapee adapee) {
		this.adapee = adapee;
	}

	@Override
	public void request() {
		System.out.println("适配器开始调用");
		adapee.specificRequest();
		System.out.println("适配器调用完毕");
	}
}
