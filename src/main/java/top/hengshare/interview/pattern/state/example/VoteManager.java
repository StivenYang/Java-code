package top.hengshare.interview.pattern.state.example;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @program: Java-Interview
 * @description: 投票管理
 * @author: Steven Yang
 * @create: 2019-10-16 11:47
 **/
public class VoteManager {

	private Map<String, String> mapVote = Maps.newHashMap();

	private Map<String, Integer> mapVoteCount = Maps.newHashMap();

	public void vote(String user, String voteItem) {
		//取得用户的已投次数
		Integer count = mapVoteCount.get(user);
		if (count == null) {
			count = 0;
		}
		count++;
		mapVoteCount.put(user, count);

		//判断用户投票的类型
		if (count == 1) {
			//正常投票
			mapVote.put(user, voteItem);
			System.out.println("投票成功");
		} else if (count > 1 && count < 5) {
			//重复投票
			System.out.println("请勿重复投票");
		} else if (count >= 5 && count < 8) {
			//恶意投票
			String s = mapVote.get(user);
			if (s != null) {
				mapVote.remove(s);
			}
			System.out.println("恶意刷票，已经取消投票资格");
		} else if (count >= 8) {
			//黑名单
			System.out.println("已经进入黑名单了，禁止登录和使用投票系统");
		}
	}
}
