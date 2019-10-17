package top.hengshare.interview.pattern.state.voteState;

/**
 * @program: Java-Interview
 * @description: 状态机接口
 * @author: Steven Yang
 * @create: 2019-10-17 20:18
 **/
public interface VoteState {
    void vote(String user, String voteItem, VoteManager votemanager);
}
