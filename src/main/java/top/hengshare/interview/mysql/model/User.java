package top.hengshare.interview.mysql.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "`user`")
public class User {
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField(value = "username")
	private String username;

	@TableField(value = "password")
	private String password;

	@TableField(value = "email")
	private String email;

	@TableField(value = "phone")
	private String phone;

	@TableField(value = "create_time")
	private Date createTime;

	@TableField(value = "creator")
	private String creator;

	@TableField(value = "update_time")
	private Date updateTime;

	@TableField(value = "updator")
	private String updator;
}