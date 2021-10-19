package top.hengshare.interview.pattern.builder.export;

import java.util.Collection;
import java.util.Map;

/**
 * 指导者，指导使用生成器的接口来构建输出的文件的对象
 */
public class Director {
	/**
	 * 当前需要使用的生成器的对象
	 */
	private Builder builder;

	/**
	 * 构建方法，初始化生成器对象
	 *
	 * @param builder
	 */
	public Director(Builder builder) {
		this.builder = builder;
	}

	/**
	 * 指导构建器生成最终的文件的对象
	 *
	 * @param header
	 * @param body
	 * @param footer
	 */
	public void construct(ExportHeaderModel header, Map<String, Collection<ExportDataModel>> body,
			ExportFooterModel footer) {
		//构建Header
		builder.buildHeader(header);
		//构建Body
		builder.buildBody(body);
		//构建footer
		builder.buildFooter(footer);
	}
}
