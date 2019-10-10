package top.hengshare.interview.pattern.builder.export;

import java.util.Collection;
import java.util.Map;

public interface Builder {
    /**
     * 构建输出文件的Header部分
     * @param ehm
     */
    void buildHeader(ExportHeaderModel ehm);

    /**
     * 构建输出文件的Body部分
     * @param mapData
     */
    void buildBody(Map<String, Collection<ExportDataModel>> mapData);

    /**
     * 构建输出文件的footer部分
     * @param footer
     */
    void buildFooter(ExportFooterModel footer);
}
