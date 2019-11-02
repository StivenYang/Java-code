package top.hengshare.interview.pattern.bridge.reExample;

/**
 * @program: Java-Interview
 * @description: MessageImplementor
 * @author: StivenYang
 * @create: 2019-11-02 19:58
 **/
public interface MessageImplementor {
    void send(String message, String toUser);
}
