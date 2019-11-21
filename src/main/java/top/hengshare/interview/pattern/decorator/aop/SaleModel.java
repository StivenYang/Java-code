package top.hengshare.interview.pattern.decorator.aop;

import lombok.Data;

import java.nio.file.Files;

/**
 * @program: Java-Interview
 * @description: 封装销售单的数据
 * @author: StivenYang
 * @create: 2019-10-31 20:07
 **/
@Data
public class SaleModel {
    /**
     * 销售的商品
     */
    private String goods;
    /**
     * 销售的数量
     */
    private int saleNum;

}
