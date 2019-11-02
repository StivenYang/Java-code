package top.hengshare.interview.pattern.bridge.reExample;

/**
 * @program: Java-Interview
 * @description: MessageSMS
 * @author: StivenYang
 * @create: 2019-11-02 20:00
 **/
public class MessageEmail implements MessageImplementor {
    @Override
    public void send(String message, String toUser) {
        System.out.println("使用Email方式发送："+message+"，给："+toUser);
    }
}
