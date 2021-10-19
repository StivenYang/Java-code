package top.hengshare.interview.pattern.prototype.example;

/**
 * 处理订单的业务对象
 */
public class OrderBussiness {
	/**
	 * 创建订单
	 *
	 * @param order
	 */
	public void saveOrder(OrderAPI order) {
		//根据业务的需要，当订单预定产品数量超过1000时，就需要把订单拆成两份订单
		//1000应该是个常量，这里使用魔数是为了方便演示

		//判断订单数量是否大于1000
		while (order.getOrderProductNum() > 1000) {
			//如果大于1000，需要继续拆分
			//创建相应的订单对象，除了数量不一样之外，其他属性方法应该都是一样的
			OrderAPI newOrder = order.cloneOrder();
			//进行赋值，产品数量为1000
			newOrder.setOrderProductNum(1000);
			//todo 这里使用instance of对order的实际类型进行了判断，这是强耦合的代码，可以在此基础上完善
			//todo 这里的需求用一句话描述就是：已经有了某个实例对象之后，如何生成更多的该实例对象（不包含属性）
			//            if (order instanceof PersonalOrder) {
			//                //创建相应的新的订单对象
			//                PersonalOrder p2 = new PersonalOrder();
			//                //然后进行赋值,但是产品数量是1000
			//                PersonalOrder p1 = (PersonalOrder) order;
			//                p2.setCustomerName(p1.getCustomerName());
			//                p2.setOrderProductNum(1000);
			//                p2.setProductId(p1.getProductId());
			//                //再设置给newOrder
			//                newOrder = p2;
			//            } else if (order instanceof EnterpriseOrder) {
			//                //创建相应的新的订单对象
			//                EnterpriseOrder p2 = new EnterpriseOrder();
			//                //然后进行赋值,但是产品数量是1000
			//                EnterpriseOrder p1 = (EnterpriseOrder) order;
			//                p2.setEnterpriseName(p1.getEnterpriseName());
			//                p2.setOrderProductNum(1000);
			//                p2.setProductId(p1.getProductId());
			//                //再设置给newOrder
			//                newOrder = p2;
			//            }
			//将原来的订单保留，把数量减少1000
			order.setOrderProductNum(order.getOrderProductNum() - 1000);
			//然后是业务处理功能，这里仅仅打印
			System.out.println("拆分生成订单==" + newOrder);
		}
		//不超过1000，直接进行业务处理，
		System.out.println("订单==" + order);

	}
}



