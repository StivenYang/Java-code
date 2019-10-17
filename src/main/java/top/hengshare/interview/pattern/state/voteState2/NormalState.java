package top.hengshare.interview.pattern.state.voteState2;

/**
 * @program: Java-Interview
 * @description: 正常投票状态
 * @author: Steven Yang
 * @create: 2019-10-17 20:20
 **/
public class NormalState implements VoteState {
    @Override
    public void vote(String user, String voteItem, VoteManager votemanager) {
        //如果是正常投票
        //记录当前投票的项目
        votemanager.getMapVate().put(user, voteItem);
        //给出提示
        System.out.println("恭喜你，投票成功");
        //设置用户下次投票将触发的状态
        votemanager.getMapState().put(user, new RepeatState());
    }
}
