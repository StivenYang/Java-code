package top.hengshare.interview.pattern.chainOfResposiblity.struct;

/**
 * @program: Java-Interview
 * @description: ConcreteHandler1
 * @author: StivenYang
 * @create: 2019-11-01 08:53
 **/
public class ConcreteHandler2 extends Handler {

    @Override
    public void handleRequest() {
        boolean someCondition = false;

        if (this.successor == null) {
            someCondition= true;
        }

        if (someCondition) {
            System.out.println("具体的处理请求2");
        }else {
            if (this.successor != null) {
                this.successor.handleRequest();
            }
        }
    }
}
