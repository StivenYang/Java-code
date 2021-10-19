package top.hengshare.interview.pattern.proxy.simpleProxy;

public class Order {

	private String productName;
	private int orderNum;
	private String orderUser;

	public Order(String productName, int orderNum, String orderUser) {
		this.productName = productName;
		this.orderNum = orderNum;
		this.orderUser = orderUser;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName, String user) {
		this.productName = productName;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum, String user) {
		this.orderNum = orderNum;
	}

	public String getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(String orderUser, String user) {
		this.orderUser = orderUser;
	}

	@Override
	public String toString() {
		return "Order{" + "productName='" + productName + '\'' + ", orderNum=" + orderNum + ", orderUser='" + orderUser
				+ '\'' + '}';
	}
}
