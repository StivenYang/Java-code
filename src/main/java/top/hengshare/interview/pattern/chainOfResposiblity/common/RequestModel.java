package top.hengshare.interview.pattern.chainOfResposiblity.common;

import lombok.Getter;

/**
 * @program: Java-Interview
 * @description: RequestModel
 * @author: StivenYang
 * @create: 2019-11-01 11:55
 **/
public class RequestModel {

	@Getter
	private String type;

	public RequestModel(String type) {
		this.type = type;
	}
}
