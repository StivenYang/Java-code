package top.hengshare.interview.pattern.builder.export;

import lombok.Data;

/**
 * 输出文件的头对象
 */
@Data
public class ExportHeaderModel {
    /**
     * 分公司或者门市点id
     */
    private String depId;

    /**
     * 导出数据的日期
     */
    private String exportDate;
}
