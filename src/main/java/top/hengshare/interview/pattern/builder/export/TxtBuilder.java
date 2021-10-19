package top.hengshare.interview.pattern.builder.export;

import java.util.Collection;
import java.util.Map;

public class TxtBuilder implements Builder {

	private StringBuffer buffer = new StringBuffer();

	@Override
	public void buildHeader(ExportHeaderModel ehm) {
		buffer.append(ehm.getDepId() + ", " + ehm.getExportDate() + "\n");
	}

	@Override
	public void buildBody(Map<String, Collection<ExportDataModel>> mapData) {
		for (String tblName : mapData.keySet()) {
			//拼接表名称
			buffer.append(tblName + "\n");
			//然后循环拼接具体数据
			for (ExportDataModel edm : mapData.get(tblName)) {
				buffer.append(edm.getProductId() + ", " + edm.getPrice() + ", " + edm.getAmount() + "\n");
			}
		}
	}

	@Override
	public void buildFooter(ExportFooterModel efm) {
		buffer.append(efm.getExportUser());
	}

	public StringBuffer getResult() {
		return buffer;
	}
}
