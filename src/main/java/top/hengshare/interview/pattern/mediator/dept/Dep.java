package top.hengshare.interview.pattern.mediator.dept;

import lombok.Data;

@Data
public class Dep {
	private String depId;
	private String depName;

	public boolean deleteDep() {
		DepUserMediatorImpl mediator = DepUserMediatorImpl.getInstance();
		return mediator.deleteDep(depId);
	}
}
