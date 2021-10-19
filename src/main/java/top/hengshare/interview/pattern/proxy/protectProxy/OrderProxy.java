package top.hengshare.interview.pattern.proxy.protectProxy;

import org.apache.commons.lang3.StringUtils;

public class OrderProxy implements OrderAPI {

	private Order order;

	public OrderProxy(Order order) {
		this.order = order;
	}

	@Override
	public String getProductName() {
		return order.getProductName();
	}

	@Override
	public void setProductName(String productName, String user) {
		if (StringUtils.isNotEmpty(user) && user.equals(this.getOrderUser())) {
			order.setProductName(productName, user);
		} else {
			System.out.println("无权限修改订单名称");
		}
	}

	@Override
	public int getOrderNum() {
		return order.getOrderNum();
	}

	@Override
	public void setOrderNum(int orderNum, String user) {
		if (StringUtils.isNotEmpty(user) && user.equals(this.getOrderUser())) {
			order.setOrderNum(orderNum, user);
		} else {
			System.out.println("无权修改订单数量");
		}
	}

	@Override
	public String getOrderUser() {
		return order.getOrderUser();
	}

	@Override
	public void setOrderUser(String orderUser, String user) {
		if (StringUtils.isNotEmpty(user) && user.equals(this.getOrderUser())) {
			order.setOrderUser(orderUser, user);
		} else {
			System.out.println("无权修改订单用户名");
		}
	}

	@Override
	public String toString() {
		return "OrderProxy{" + "order=" + order + '}';
	}
}
