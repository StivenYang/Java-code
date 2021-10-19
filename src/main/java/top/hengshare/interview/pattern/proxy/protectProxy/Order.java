package top.hengshare.interview.pattern.proxy.protectProxy;

public class Order implements OrderAPI {

	private String productName;
	private int orderNum;
	private String orderUser;

	public Order(String productName, int orderNum, String orderUser) {
		this.productName = productName;
		this.orderNum = orderNum;
		this.orderUser = orderUser;
	}

	@Override
	public String getProductName() {
		return productName;
	}

	@Override
	public void setProductName(String productName, String user) {
		this.productName = productName;
	}

	@Override
	public int getOrderNum() {
		return orderNum;
	}

	@Override
	public void setOrderNum(int orderNum, String user) {
		this.orderNum = orderNum;
	}

	@Override
	public String getOrderUser() {
		return orderUser;
	}

	@Override
	public void setOrderUser(String orderUser, String user) {
		this.orderUser = orderUser;
	}

	@Override
	public String toString() {
		return "Order{" + "productName='" + productName + '\'' + ", orderNum=" + orderNum + ", orderUser='" + orderUser
				+ '\'' + '}';
	}
}
