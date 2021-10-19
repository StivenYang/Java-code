package top.hengshare.interview.pattern.templateMethod.sort;

import lombok.Data;

/**
 * @program: Java-Interview
 * @description: 用户数据模型
 * @author: Steven Yang
 * @create: 2019-10-15 19:07
 **/
@Data
public class UserModel {
	private String userId, name;
	private int age;

	public UserModel(String userId, String name, int age) {
		this.userId = userId;
		this.name = name;
		this.age = age;
	}
}
