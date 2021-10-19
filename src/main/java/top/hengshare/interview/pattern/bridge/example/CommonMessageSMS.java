package top.hengshare.interview.pattern.bridge.example;

/**
 * @program: Java-Interview
 * @description: CommonMessageSMS
 * @author: StivenYang
 * @create: 2019-11-02 19:40
 **/
public class CommonMessageSMS implements Message {
	@Override
	public void send(String message, String toUser) {
		System.out.println("使用站内短消息的方式，发送消息" + message + "给：" + toUser);
	}
}
