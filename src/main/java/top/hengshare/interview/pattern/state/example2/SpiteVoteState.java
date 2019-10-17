package top.hengshare.interview.pattern.state.example2;

/**
 * @program: Java-Interview
 * @description: 恶意投票
 * @author: Steven Yang
 * @create: 2019-10-16 15:12
 **/
public class SpiteVoteState implements VoteState {
    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //取消投票资格
        String s = voteManager.getMapVote().get(user);
        if (s != null) {
            voteManager.getMapVote().remove(user);
        }
        System.out.println("存在恶意刷票行为，取消投票资格");
    }
}
