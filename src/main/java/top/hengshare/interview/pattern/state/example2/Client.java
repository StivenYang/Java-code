package top.hengshare.interview.pattern.state.example2;

import top.hengshare.interview.pattern.mediator.dept.User;

/**
 * @program: Java-Interview
 * @description: 测试状态机模式
 * @author: Steven Yang
 * @create: 2019-10-16 15:28
 **/
public class Client {
    public static void main(String[] args) {
        VoteManager manager = new VoteManager();
        for (int i = 0; i < 8; i++) {
            manager.vote("u1", "A");
        }
    }
}
