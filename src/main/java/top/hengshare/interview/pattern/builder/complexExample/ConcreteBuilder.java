package top.hengshare.interview.pattern.builder.complexExample;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * 具体的构建器对象
 */
@Data
public class ConcreteBuilder {
    private String contractId;
    private String personName;
    private String companyName;
    private long beginDate;
    private long endDate;
    private String otherData;

    /**
     * 构建对象的必填参数
     * @param contractId
     * @param beginDate
     * @param endDate
     */
    public ConcreteBuilder(String contractId, long beginDate, long endDate) {
        this.contractId = contractId;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    /**
     * 选填数据：被保险人名称
     */
    public ConcreteBuilder setPersonName(String personName){
        this.personName = personName;
        return this;
    }
    /**
     * 选填数据：被保险公司名称
     */
    public ConcreteBuilder setCompanyName(String companyName){
        this.companyName = companyName;
        return this;
    }
    public ConcreteBuilder setOtherData(String otherData){
        this.otherData = otherData;
        return this;
    }

    public InsuranceContract build() {
        if (StringUtils.isEmpty(contractId)){
            throw new IllegalArgumentException("合同编号不能为空");
        }
        if (StringUtils.isNotEmpty(personName) && StringUtils.isNotEmpty(companyName)){
            throw new IllegalArgumentException("一份保险合同不能同时与个人和公司签订合同");
        }
        if (StringUtils.isEmpty(personName) && StringUtils.isEmpty(companyName)){
            throw new IllegalArgumentException("一份保险合同不能没有签订对象");
        }
        if (beginDate <= 0) {
            throw new IllegalArgumentException("合同必须有开始生效的日期");
        }
        if (endDate <= 0){
            throw new IllegalArgumentException("合同必须有最后失效的日期");
        }
        if (beginDate >= endDate) {
            throw new IllegalArgumentException("保险失效的日期必须大于保险生效的日期");
        }

        return new InsuranceContract(this);
    }
}
