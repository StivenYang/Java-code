package top.hengshare.interview.pattern.prototype.unstruct;

import lombok.Data;

@Data
public class PersonalOrder implements OrderAPI {

	/**
	 * 顾客姓名
	 */
	private String customerName;
	/**
	 * 产品id
	 */
	private String productId;
	/**
	 * 订单产品数量
	 */
	private int orderProductNum;

	@Override
	public int getOrderProductNum() {
		return this.orderProductNum;
	}

	@Override
	public void setOrderProductNum(int num) {
		this.orderProductNum = num;
	}
}
