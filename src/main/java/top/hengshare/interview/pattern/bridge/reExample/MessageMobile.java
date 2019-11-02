package top.hengshare.interview.pattern.bridge.reExample;

/**
 * @program: Java-Interview
 * @description: MessageMobile
 * @author: StivenYang
 * @create: 2019-11-02 20:07
 **/
public class MessageMobile implements MessageImplementor {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用手机短消息的方式，发送短信：" + message + "，给：" + toUser);
    }
}
