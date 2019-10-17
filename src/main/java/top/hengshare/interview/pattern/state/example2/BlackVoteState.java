package top.hengshare.interview.pattern.state.example2;

/**
 * @program: Java-Interview
 * @description: 黑名单状态
 * @author: Steven Yang
 * @create: 2019-10-16 15:16
 **/
public class BlackVoteState implements VoteState {
    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        System.out.println("已进入黑名单，禁止登陆");
    }
}
