package top.hengshare.interview.pattern.bridge.reExample;

/**
 * @program: Java-Interview
 * @description: AbstractMessage
 * @author: StivenYang
 * @create: 2019-11-02 19:58
 **/
public abstract class AbstractMessage {
    protected MessageImplementor impl;

    public AbstractMessage(MessageImplementor impl) {
        this.impl = impl;
    }

    public void sendMessage(String message, String toUser){
        this.impl.send(message, toUser);
    }
}
