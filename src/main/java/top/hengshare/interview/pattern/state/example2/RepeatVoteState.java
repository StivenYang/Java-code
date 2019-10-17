package top.hengshare.interview.pattern.state.example2;

/**
 * @program: Java-Interview
 * @description: 重复投票处理
 * @author: Steven Yang
 * @create: 2019-10-16 15:10
 **/
public class RepeatVoteState implements VoteState{

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        System.out.println("请不要重复投票，谢谢");
    }
}
