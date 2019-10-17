package top.hengshare.interview.pattern.state.voteState2;

/**
 * @program: Java-Interview
 * @description: 黑名单警告类
 * @author: Steven Yang
 * @create: 2019-10-17 20:55
 **/
public class BlackWarnState implements VoteState {
    @Override
    public void vote(String user, String voteItem, VoteManager votemanager) {
        //如果进入黑名单，取消之前的有效投票记录，然后直接提示就可以了
        votemanager.getMapVate().remove(user);
        System.out.println("之前的投票无效，并禁止使用系统3天");
        Integer count = votemanager.getMapVateCount().get(user);
        if (count == 9) {
            votemanager.getMapState().put(user, new BlackState());
        }
    }
}
