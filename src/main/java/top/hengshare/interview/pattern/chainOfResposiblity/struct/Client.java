package top.hengshare.interview.pattern.chainOfResposiblity.struct;

/**
 * @program: Java-Interview
 * @description: Client
 * @author: StivenYang
 * @create: 2019-11-01 08:55
 **/
public class Client {
    public static void main(String[] args) {
        //先组装职责链
        ConcreteHandler1 handler1 = new ConcreteHandler1();
        ConcreteHandler2 handler2 = new ConcreteHandler2();

        handler1.setSuccessor(handler2);
        //提交请求
        handler1.handleRequest();
    }
}
