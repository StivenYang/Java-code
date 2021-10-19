package top.hengshare.interview.pattern.bridge.reExample;

/**
 * @program: Java-Interview
 * @description: UrgencyMessage
 * @author: StivenYang
 * @create: 2019-11-02 20:03
 **/
public class UrgencyMessage extends AbstractMessage {
	public UrgencyMessage(MessageImplementor impl) {
		super(impl);
	}

	@Override
	public void sendMessage(String message, String toUser) {
		message = "加急：" + message;
		super.sendMessage(message, toUser);
	}

	/**
	 * 监控某个加急消息的处理过程
	 * @param messageId
	 * @return
	 */
	public Object watch(String messageId) {
		return null;
	}
}
