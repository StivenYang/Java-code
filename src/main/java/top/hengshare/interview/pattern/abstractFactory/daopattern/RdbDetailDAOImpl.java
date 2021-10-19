package top.hengshare.interview.pattern.abstractFactory.daopattern;

public class RdbDetailDAOImpl implements OrderDetailDAO {
	@Override
	public void saveOrderDetail() {
		System.out.println("现在使用的是：RdbDetailDAOImpl");
	}
}
