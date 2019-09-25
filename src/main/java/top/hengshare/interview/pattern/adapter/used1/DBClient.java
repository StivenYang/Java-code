package top.hengshare.interview.pattern.adapter.used1;

import com.google.common.collect.Lists;
import top.hengshare.interview.pattern.adapter.LogFileOparate;
import top.hengshare.interview.pattern.adapter.LogModel;

import java.util.List;

/**
 * 适配器客户端
 */
public class DBClient {
    public static void main(String[] args) {
        LogModel logModel = new LogModel();
        logModel.setLogId("002");
        logModel.setOperateUser("yang");
        logModel.setLogContent("这个是适配器模式客户端");
        logModel.setOperateTime("20191109");

        List<LogModel> list = Lists.newArrayList();
        list.add(logModel);
        list.add(logModel);

        //开始操作日志文件
        LogFileOparate lfo = new LogFileOparate("");
        Adapter adapter = new Adapter(lfo);
        adapter.getAllLog().forEach(System.out::println);

    }
}
