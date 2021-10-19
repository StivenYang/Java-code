package top.hengshare.interview.pattern.state.voteState2;

/**
 * @program: Java-Interview
 * @description: 黑名单状态
 * @author: Steven Yang
 * @create: 2019-10-17 20:22
 **/
public class BlackState implements VoteState {
	@Override
	public void vote(String user, String voteItem, VoteManager votemanager) {
		System.out.println("已经进入黑名单");
	}
}
