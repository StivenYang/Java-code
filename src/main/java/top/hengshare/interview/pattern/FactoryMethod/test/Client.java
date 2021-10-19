package top.hengshare.interview.pattern.FactoryMethod.test;

public class Client {
	public static void main(String[] args) {
		ExportOperate operate = new DBExportOperate();
		operate.export();
		ExportApi exportApi = operate.factoryMethod();
		exportApi.export();
	}
}
