package top.hengshare.interview.mysql.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "arg_record_log")
public class ArgRecordLog {
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 操作人
	 */
	@TableField(value = "operator")
	private String operator;

	/**
	 * ip地址
	 */
	@TableField(value = "ip_address")
	private String ipAddress;

	/**
	 * 访问URL
	 */
	@TableField(value = "access_url")
	private String accessUrl;

	/**
	 * 操作时间
	 */
	@TableField(value = "operate_time")
	private Date operateTime;

	/**
	 * 动作代码
	 */
	@TableField(value = "action_code")
	private Integer actionCode;

	/**
	 * 动作名称
	 */
	@TableField(value = "action_name")
	private String actionName;

	/**
	 * 操作内容
	 */
	@TableField(value = "content")
	private String content;

	/**
	 * 是否成功(如果没有异常，都算成功)0：成功，1：失败
	 */
	@TableField(value = "success_flag")
	private Byte successFlag;
}