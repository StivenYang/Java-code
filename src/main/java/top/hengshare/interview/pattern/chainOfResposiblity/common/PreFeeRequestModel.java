package top.hengshare.interview.pattern.chainOfResposiblity.common;

import lombok.Data;

/**
 * @program: Java-Interview
 * @description: PreFeeRequestModel
 * @author: StivenYang
 * @create: 2019-11-01 15:32
 **/
@Data
public class PreFeeRequestModel extends RequestModel {
	public final static String FEE_TYPE = "preFee";

	public PreFeeRequestModel() {
		super(FEE_TYPE);
	}

	/**
	 * 申请人
	 */
	private String user;

	/**
	 * 申请金额
	 */
	private double fee;
}
