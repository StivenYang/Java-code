package top.hengshare.interview.pattern.state.voteState2;

/**
 * @program: Java-Interview
 * @description: 测试转换状态机
 * @author: Steven Yang
 * @create: 2019-10-17 20:50
 **/
public class Client {
	public static void main(String[] args) {
		VoteManager voteManager = new VoteManager();
		for (int i = 0; i < 11; i++) {
			voteManager.vote("张三", "统一建设");
		}
	}
}
