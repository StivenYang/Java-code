package top.hengshare.interview.pattern.proxy.simpleProxy;

import org.apache.commons.lang3.StringUtils;

public class OrderProxy extends Order {
	public OrderProxy(String productName, int orderNum, String orderUser) {
		super(productName, orderNum, orderUser);
	}

	@Override
	public void setProductName(String productName, String user) {
		if (StringUtils.isNotEmpty(user) && user.equals(this.getOrderUser())) {
			super.setProductName(productName, user);
		} else {
			System.out.println("无权限修改订单名称");
		}
	}

	@Override
	public void setOrderNum(int orderNum, String user) {
		if (StringUtils.isNotEmpty(user) && user.equals(this.getOrderUser())) {
			super.setOrderNum(orderNum, user);
		} else {
			System.out.println("无权修改订单数量");
		}
	}

	@Override
	public void setOrderUser(String orderUser, String user) {
		if (StringUtils.isNotEmpty(user) && user.equals(this.getOrderUser())) {
			super.setOrderUser(orderUser, user);
		} else {
			System.out.println("无权修改订单用户名");
		}
	}
}
