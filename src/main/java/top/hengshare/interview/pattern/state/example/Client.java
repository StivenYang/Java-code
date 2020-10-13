package top.hengshare.interview.pattern.state.example;

/**
 * @program: Java-Interview
 * @description: 测试不带模式的投票系统
 * @author: Steven Yang
 * @create: 2019-10-16 11:55
 **/
public class Client {
    public static void main(String[] args) {
        VoteManager voteManager = new VoteManager();
        for (int i = 0; i < 8; i++) {
            voteManager.vote("u1", "A");
        }
    }
}
