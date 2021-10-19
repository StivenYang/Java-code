package top.hengshare.interview.pattern.FactoryMethod.test;

public class FileExport implements ExportApi {

	@Override
	public boolean export() {
		System.out.println("文件导出");
		return true;
	}
}
