package top.hengshare.interview.pattern.state.example2;

/**
 * @program: Java-Interview
 * @description: 投票接口
 * @author: Steven Yang
 * @create: 2019-10-16 14:54
 **/
public interface VoteState {
	/**
	 * 处理状态对应的行为
	 * @param user 投票人
	 * @param voteItem 投票项
	 * @param voteManager 投票上下文
	 */
	void vote(String user, String voteItem, VoteManager voteManager);
}
