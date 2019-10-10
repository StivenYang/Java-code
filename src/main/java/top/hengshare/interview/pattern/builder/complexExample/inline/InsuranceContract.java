package top.hengshare.interview.pattern.builder.complexExample.inline;

import lombok.Data;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

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
     * 具体的构建器对象
     */
    @Getter
    public static class ConcreteBuilder {
        private String contractId;
        private String personName;
        private String companyName;
        private long beginDate;
        private long endDate;
        private String otherData;

        /**
         * 构建对象的必填参数
         *
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
        public ConcreteBuilder setPersonName(String personName) {
            this.personName = personName;
            return this;
        }

        /**
         * 选填数据：被保险公司名称
         */
        public ConcreteBuilder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public ConcreteBuilder setOtherData(String otherData) {
            this.otherData = otherData;
            return this;
        }

        public InsuranceContract build() {
            if (StringUtils.isEmpty(contractId)) {
                throw new IllegalArgumentException("合同编号不能为空");
            }
            if (StringUtils.isNotEmpty(personName) && StringUtils.isNotEmpty(companyName)) {
                throw new IllegalArgumentException("一份保险合同不能同时与个人和公司签订合同");
            }
            if (StringUtils.isEmpty(personName) && StringUtils.isEmpty(companyName)) {
                throw new IllegalArgumentException("一份保险合同不能没有签订对象");
            }
            if (beginDate <= 0) {
                throw new IllegalArgumentException("合同必须有开始生效的日期");
            }
            if (endDate <= 0) {
                throw new IllegalArgumentException("合同必须有最后失效的日期");
            }
            if (beginDate >= endDate) {
                throw new IllegalArgumentException("保险失效的日期必须大于保险生效的日期");
            }

            return new InsuranceContract(this);
        }
    }

    /**
     * 合同的一下具体操作
     */
    public void someOperation() {
        System.out.println("当前合同编号是：" + this.contractId);
    }
}