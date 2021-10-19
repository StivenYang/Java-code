package top.hengshare.interview.pattern.FactoryMethod.test;

public class FileExportOperator extends ExportOperate {
	@Override
	protected ExportApi factoryMethod() {
		return new FileExport();
	}
}
