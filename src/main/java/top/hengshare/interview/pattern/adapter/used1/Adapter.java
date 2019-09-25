package top.hengshare.interview.pattern.adapter.used1;

import top.hengshare.interview.pattern.adapter.LogFileOparate;
import top.hengshare.interview.pattern.adapter.LogFileOperateAPI;
import top.hengshare.interview.pattern.adapter.LogModel;

import java.util.List;

/**
 * 要实现在插入数据库的同时也写入文件
 */
public class Adapter implements LogDbOperateAPI {

    private LogFileOperateAPI logFileOperateAPI;

    public Adapter(LogFileOparate logFileOparate) {
        this.logFileOperateAPI = logFileOparate;
    }

    public void createLog(LogModel logModel) {
        //打开文件
        List<LogModel> list = logFileOperateAPI.readLogFile();
        //插入新的日志对象
        list.add(logModel);
        //重新写入文件
        logFileOperateAPI.writeLogFile(list);
    }

    public List<LogModel> getAllLog() {
        return logFileOperateAPI.readLogFile();
    }

}
