package top.hengshare.interview.pattern.builder.export;

import lombok.Data;

/**
 * 导出文件的数据体部分对象
 */
@Data
public class ExportDataModel {
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 销售价格
     */
    private double price;
    /**
     * 销售数量
     */
    private double amount;
}
