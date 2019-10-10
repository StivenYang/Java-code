package top.hengshare.interview.pattern.builder.complexExample;

import lombok.Data;

/**
 * 保险合同的对象
 */
@Data
public class InsuranceContract {
    /**
     * 保险合同编号
     */
    private String contractId;
    /**
     * 被保险人名称（与被保险公司名称不可同时存在）
     */
    private String personName;
    /**
     * 被保险公司名称（与被保险人名称不可同时存在）
     */
    private String companyName;
    /**
     * 保险开始生效的日期
     */
    private long beginDate;
    /**
     * 保险失效的日期，一定会大于保险生效的日期
     */
    private long endDate;
    /**
     * 其他数据
     */
    private String otherData;

    /**
     * 使用默认的private访问权限，防止合同对象直接被初始化，保证只能通过构建器来构建对象
     */
    InsuranceContract(ConcreteBuilder builder) {
        this.contractId = builder.getContractId();
        this.personName = builder.getPersonName();
        this.companyName = builder.getCompanyName();
        this.beginDate = builder.getBeginDate();
        this.endDate = builder.getEndDate();
        this.otherData = builder.getOtherData();
    }

    /**
     * 合同的一下具体操作
     */
    public void someOperation(){
        System.out.println("当前合同编号是：" + this.contractId);
    }
}
