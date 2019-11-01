package top.hengshare.interview.pattern.chainOfResposiblity.example;

/**
 * @program: Java-Interview
 * @description: Client
 * @author: StivenYang
 * @create: 2019-10-31 21:56
 **/
public class Client {
    public static void main(String[] args) {
        FeeRequest feeRequest = new FeeRequest();

        //开始测试
        String ret1 = feeRequest.requestToProjectManager("小李", 300);
        System.out.println(ret1);
        String ret2 = feeRequest.requestToProjectManager("小张", 300);
        System.out.println(ret2);

        String ret11 = feeRequest.requestToProjectManager("小李", 800);
        System.out.println(ret11);
        String ret22 = feeRequest.requestToProjectManager("小张", 800);
        System.out.println(ret22);

        String ret111 = feeRequest.requestToProjectManager("小李", 1200);
        System.out.println(ret111);
        String ret222 = feeRequest.requestToProjectManager("小张", 1200);
        System.out.println(ret222);

    }
}
