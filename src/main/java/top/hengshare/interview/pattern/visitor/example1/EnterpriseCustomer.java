package top.hengshare.interview.pattern.visitor.example1;

import lombok.Data;

/**
 * @program: Java-Interview
 * @description: EnterpriseCustomner
 * @author: StivenYang
 * @create: 2019-11-03 19:12
 **/
@Data
public class EnterpriseCustomer extends Customer {
    /**
     * 联系人
     */
    private String linkman;
    /**
     * 联系电话
     */
    private String linkTelephone;
    /**
     * 企业注册地址
     */
    private String registerAddress;

    @Override
    public void accept(Visitor visitor) {
        visitor.visitEnterpriseCustomer(this);
    }
}
