package top.hengshare.interview.pattern.builder.export;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

public class Client {
	public static void main(String[] args) {
		//准备测试数据
		ExportHeaderModel header = new ExportHeaderModel();
		header.setDepId("分公司一");
		header.setExportDate(LocalDate.now().toString());

		Map<String, Collection<ExportDataModel>> body = Maps.newHashMap();
		Collection<ExportDataModel> list = Lists.newArrayList();
		ExportDataModel dataModel1 = new ExportDataModel();
		dataModel1.setAmount(80);
		dataModel1.setPrice(10);
		dataModel1.setProductId("产品001");

		ExportDataModel dataModel2 = new ExportDataModel();
		dataModel2.setProductId("产品002");
		dataModel2.setPrice(20);
		dataModel2.setAmount(40);

		list.add(dataModel1);
		list.add(dataModel2);
		body.put("销售记录表", list);

		ExportFooterModel footer = new ExportFooterModel();
		footer.setExportUser("张三");


		//输出测试
		//输出到文本文件
		TxtBuilder txtBuilder = new TxtBuilder();
		Director director = new Director(txtBuilder);
		director.construct(header, body, footer);
		System.out.println(txtBuilder.getResult());

		//输出到xml文件
		XMLBuilder xmlBuilder = new XMLBuilder();
		Director director2 = new Director(xmlBuilder);
		director2.construct(header, body, footer);
		System.out.println(xmlBuilder.getResult());
	}
}
