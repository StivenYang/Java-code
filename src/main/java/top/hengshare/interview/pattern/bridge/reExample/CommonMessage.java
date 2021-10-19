package top.hengshare.interview.pattern.bridge.reExample;

/**
 * @program: Java-Interview
 * @description: CommonMessage
 * @author: StivenYang
 * @create: 2019-11-02 20:02
 **/
public class CommonMessage extends AbstractMessage {
	public CommonMessage(MessageImplementor impl) {
		super(impl);
	}

	@Override
	public void sendMessage(String message, String toUser) {
		super.sendMessage(message, toUser);
	}
}
