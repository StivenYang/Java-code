package top.hengshare.interview.pattern.state.voteState;

import com.google.common.collect.Maps;
import lombok.Getter;

import java.util.Map;

/**
 * @program: Java-Interview
 * @description: 投票状态管理器
 * @author: Steven Yang
 * @create: 2019-10-17 20:22
 **/
public class VoteManager {

	/**
	 * 存放用户和他要投票的项目
	 */
	@Getter
	private Map<String, String> mapVate = Maps.newHashMap();

	/**
	 * 存放用户和他投的票数
	 */
	@Getter
	private Map<String, Integer> mapVateCount = Maps.newHashMap();

	/**
	 * 存放用户当前的状态
	 */
	@Getter
	private Map<String, VoteState> mapState = Maps.newHashMap();

	public void vote(String user, String voteItem) {
		//1. 先判断用户是否是首次投票
		Integer count = mapVateCount.get(user);
		if (count == null) {
			count = 0;
		}
		count++;
		mapVateCount.put(user, count);

		//2. 获取该用户的投票状态
		VoteState state = mapState.get(user);
		if (state == null) {
			state = new NormalState();
		}

		//3. 基于当前用户的状态接着投票
		state.vote(user, voteItem, this);
	}
}
