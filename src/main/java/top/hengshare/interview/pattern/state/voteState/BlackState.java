package top.hengshare.interview.pattern.state.voteState;

/**
 * @program: Java-Interview
 * @description: 黑名单状态
 * @author: Steven Yang
 * @create: 2019-10-17 20:22
 **/
public class BlackState implements VoteState {
    @Override
    public void vote(String user, String voteItem, VoteManager votemanager) {
        //如果进入黑名单，取消之前的有效投票记录，然后直接提示就可以了
        votemanager.getMapVate().remove(user);
        System.out.println("你已经进入黑名单，之前的投票无效");
    }
}
