package top.hengshare.interview.pattern.state.example2;

/**
 * @program: Java-Interview
 * @description: 正常投票
 * @author: Steven Yang
 * @create: 2019-10-16 15:03
 **/
public class NormalVoteState implements VoteState {
	@Override
	public void vote(String user, String voteItem, VoteManager voteManager) {
		//从状态机中取得投票集合，将投票信息放进去
		voteManager.getMapVote().put(user, voteItem);
		System.out.println("投票成功");
	}
}
