package top.hengshare.interview.pattern.bridge.reExample;

/**
 * @program: Java-Interview
 * @description: Client
 * @author: StivenYang
 * @create: 2019-11-02 20:08
 **/
public class Client {
	public static void main(String[] args) {
		//创建具体的实现对象
		MessageImplementor impl = new MessageSMS();
		//创建一个普通消息对象
		AbstractMessage m = new CommonMessage(impl);
		m.sendMessage("请你喝一杯茶", "小李");
		//创建一个紧急消息
		m = new UrgencyMessage(impl);
		m.sendMessage("请你喝一杯茶", "小李");
		//创建一个特级消息
		m = new SpecialUrgencyMessage(impl);
		m.sendMessage("请你喝一杯茶", "小李");

		//切换发送方式为手机发送
		impl = new MessageMobile();
		m = new CommonMessage(impl);
		m.sendMessage("请你喝一杯茶", "小李");
		//创建一个紧急消息
		m = new UrgencyMessage(impl);
		m.sendMessage("请你喝一杯茶", "小李");
		//创建一个特级消息
		m = new SpecialUrgencyMessage(impl);
		m.sendMessage("请你喝一杯茶", "小李");
	}
}
