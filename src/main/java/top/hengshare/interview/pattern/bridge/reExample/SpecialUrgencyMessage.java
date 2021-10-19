package top.hengshare.interview.pattern.bridge.reExample;

/**
 * @program: Java-Interview
 * @description: SpecialUrgencyMessage
 * @author: StivenYang
 * @create: 2019-11-02 20:06
 **/
public class SpecialUrgencyMessage extends AbstractMessage {
	public SpecialUrgencyMessage(MessageImplementor impl) {
		super(impl);
	}

	@Override
	public void sendMessage(String message, String toUser) {
		message = "特急：" + message;
		super.sendMessage(message, toUser);
	}

	public void hurry(String messageId) {
		//执行特级消息的催促过程，发出催促的短信
	}
}
