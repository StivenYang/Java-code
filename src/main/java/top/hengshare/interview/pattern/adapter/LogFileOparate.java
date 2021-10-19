package top.hengshare.interview.pattern.adapter;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.List;

public class LogFileOparate implements LogFileOperateAPI {

	private String logFilePathName = "d:/log.log";

	public LogFileOparate(String logFilePathName) {
		if (StringUtils.isNotEmpty(logFilePathName)) {
			this.logFilePathName = logFilePathName;
		}
	}

	@Override
	public List<LogModel> readLogFile() {
		List<LogModel> list = null;
		ObjectInputStream ois = null;

		//读取日志文件
		try {
			File f = new File(logFilePathName);
			if (f.exists()) {
				ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
				list = (List<LogModel>) ois.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void writeLogFile(List<LogModel> list) {
		File f = new File(logFilePathName);
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			oos.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
