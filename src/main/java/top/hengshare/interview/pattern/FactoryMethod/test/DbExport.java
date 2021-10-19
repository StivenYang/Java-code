package top.hengshare.interview.pattern.FactoryMethod.test;

public class DbExport implements ExportApi {
	@Override
	public boolean export() {
		System.out.println("数据库导出");
		return true;
	}
}
