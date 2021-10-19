package top.hengshare.interview.pattern.bridge.example;

/**
 * @program: Java-Interview
 * @description: Message
 * @author: StivenYang
 * @create: 2019-11-02 19:39
 **/
public interface Message {

	void send(String message, String toUser);
}
