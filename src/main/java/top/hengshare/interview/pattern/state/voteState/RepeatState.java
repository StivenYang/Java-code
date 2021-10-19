package top.hengshare.interview.pattern.state.voteState;

import java.util.Map;

/**
 * @program: Java-Interview
 * @description: 重复投票状态
 * @author: Steven Yang
 * @create: 2019-10-17 20:20
 **/
public class RepeatState implements VoteState {
	@Override
	public void vote(String user, String voteItem, VoteManager votemanager) {
		//如果是重复投票
		//给出提示
		System.out.println("请不要重复投票");
		//判断投票次数，设置用户下次投票将触发的状态
		Map<String, Integer> mapVateCount = votemanager.getMapVateCount();
		Integer count = mapVateCount.get(user);
		//如果重复投票3次，第四次投票将触发恶意投票警告
		if (count == 3) {
			votemanager.getMapState().put(user, new SpiteState());
		}
	}
}
