package top.hengshare.interview.pattern.adapter;

import java.util.List;

/**
 * 日志文件操作接口
 */
public interface LogFileOperateAPI {
	List<LogModel> readLogFile();

	void writeLogFile(List<LogModel> list);
}
