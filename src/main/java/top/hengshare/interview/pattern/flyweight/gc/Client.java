package top.hengshare.interview.pattern.flyweight.gc;

/**
 * @program: Java-Interview
 * @description: Client
 * @author: StivenYang
 * @create: 2019-10-23 18:24
 **/
public class Client {
	public static void main(String[] args) {
		SecurityMgr mgr = SecurityMgr.getInstance();
		boolean f1 = mgr.hasPermit("张三", "薪资数据", "查看");
		boolean f2 = mgr.hasPermit("李四", "薪资数据", "查看");
		boolean f3 = mgr.hasPermit("李四", "薪资数据", "修改");

		for (int i = 0; i < 3; i++) {
			mgr.hasPermit("张三" + i, "薪资数据", "查看");
		}

		//查看缓存命中次数
		System.out.println("薪资数据，查看 被引用了" + FlyweightFactory.getInstance().getUseTimes("薪资数据,查看") + "次");
		System.out.println("薪资数据，修改 被引用了" + FlyweightFactory.getInstance().getUseTimes("薪资数据,修改") + "次");
		System.out.println("人员列表，查看 被引用了" + FlyweightFactory.getInstance().getUseTimes("人员列表,查看") + "次");
	}
}
