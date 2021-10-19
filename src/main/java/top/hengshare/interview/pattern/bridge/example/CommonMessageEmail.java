package top.hengshare.interview.pattern.bridge.example;

/**
 * @program: Java-Interview
 * @description: CommonMessageEmail
 * @author: StivenYang
 * @create: 2019-11-02 19:41
 **/
public class CommonMessageEmail implements Message {
	@Override
	public void send(String message, String toUser) {
		System.out.println("使用Email的方式，发送消息" + message + "给：" + toUser);
	}
}
