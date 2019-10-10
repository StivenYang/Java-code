package top.hengshare.interview.pattern.FactoryMethod.test;

public class DBExportOperate extends ExportOperate {
    @Override
    protected ExportApi factoryMethod() {
        return new DbExport();
    }
}
