package top.hengshare.interview.pattern.adapter;

import lombok.Data;

import java.io.Serializable;

@Data
public class LogModel implements Serializable {
	private String logId;
	private String operateUser;
	private String operateTime;
	private String logContent;
}
