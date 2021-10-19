package top.hengshare.interview.pattern.mediator.dept;

import lombok.Data;

@Data
public class User {
	private String userId;
	private String userName;

	public boolean dimission() {
		DepUserMediatorImpl mediator = DepUserMediatorImpl.getInstance();
		return mediator.deleteUser(userId);
	}
}
