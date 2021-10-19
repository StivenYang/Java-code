package top.hengshare.interview.pattern.state.example2;

import com.google.common.collect.Maps;
import lombok.Getter;

import java.util.Map;

/**
 * @program: Java-Interview
 * @description: 状态管理上下文
 * @author: Steven Yang
 * @create: 2019-10-16 15:03
 **/
public class VoteManager {

	private VoteState state;

	@Getter
	private Map<String, String> mapVote = Maps.newHashMap();

	@Getter
	private Map<String, Integer> mapVoteCount = Maps.newHashMap();

	public void vote(String user, String voteItem) {
		Integer count = mapVoteCount.get(user);
		if (count == null) {
			count = 0;
		}
		count++;
		mapVoteCount.put(user, count);
		if (count == 1) {
			state = new NormalVoteState();
		} else if (count > 1 && count < 5) {
			state = new RepeatVoteState();
		} else if (count >= 5 && count < 8) {
			state = new SpiteVoteState();
		} else if (count >= 8) {
			state = new BlackVoteState();
		}

		//转掉相应的状态处理机
		state.vote(user, voteItem, this);
	}
}
