package top.hengshare.interview.pattern.visitor.example1;

/**
 * @program: Java-Interview
 * @description: PersonalCustomer
 * @author: StivenYang
 * @create: 2019-11-03 19:23
 **/
public class PersonalCustomer extends Customer {

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 年龄
     */
    private int age;

    @Override
    public void accept(Visitor visitor) {
        visitor.visitPersonCustomer(this);
    }
}
