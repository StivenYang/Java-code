package top.hengshare.interview.pattern.FactoryMethod.test;

/**
 * 实现导出数据的业务功能对象
 */
public abstract class ExportOperate {

	public boolean export() {
		ExportApi exportApi = factoryMethod();
		return exportApi.export();
	}

	protected abstract ExportApi factoryMethod();
}
