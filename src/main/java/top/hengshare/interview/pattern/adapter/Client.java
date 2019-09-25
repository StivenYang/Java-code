package top.hengshare.interview.pattern.adapter;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 正常使用的客户端
 */
public class Client {
    public static void main(String[] args) {
        //测试数据
        LogModel lm = new LogModel();
        lm.setLogContent("这是一条测试数据");
        lm.setLogId("001");
        lm.setOperateUser("admin");
        lm.setOperateTime("20190924");

        List<LogModel> list = Lists.newArrayList();
        list.add(lm);
        list.add(lm);
        list.add(lm);
        list.add(lm);

        LogFileOparate oparate = new LogFileOparate("");
        oparate.writeLogFile(list);

        List<LogModel> logModels = oparate.readLogFile();
        logModels.forEach(System.out::println);
    }
}
