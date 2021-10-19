package top.hengshare.interview.pattern.bridge.example;

/**
 * @program: Java-Interview
 * @description: UrgencyMessageSMS
 * @author: StivenYang
 * @create: 2019-11-02 19:45
 **/
public class UrgencyMessageEmail implements UrgencyMessage {
	@Override
	public Object watch(String messageId) {
		return null;
	}

	@Override
	public void send(String message, String toUser) {
		message = "加急：" + message;
		System.out.println("使用Email的方式，发送消息" + message + "给：" + toUser);
	}
}
