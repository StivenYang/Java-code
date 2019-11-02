package top.hengshare.interview.pattern.bridge.example;

/**
 * @program: Java-Interview
 * @description: UrgencyMessage
 * @author: StivenYang
 * @create: 2019-11-02 19:43
 **/
public interface UrgencyMessage extends Message {
    /**
     * 监控某消息的处理过程
     * @param messageId 被监控的消息的编号
     * @return 包含监控到的数据对象
     */
    Object watch(String messageId);
}
