package top.hengshare.interview.pattern.state.voteState;

/**
 * @program: Java-Interview
 * @description: 恶意投票状态
 * @author: Steven Yang
 * @create: 2019-10-17 20:21
 **/
public class SpiteState implements VoteState {
	@Override
	public void vote(String user, String voteItem, VoteManager votemanager) {
		//如果是恶意投票
		//给出提示
		System.out.println("请不要恶意投票");
		//判断投票次数，设置用户下次投票将触发的状态
		Integer count = votemanager.getMapVateCount().get(user);
		if (count == 5) {
			//如果恶意投票5次，第6次投票将触发恶意投票警告
			votemanager.getMapState().put(user, new BlackState());
		}
	}
}
