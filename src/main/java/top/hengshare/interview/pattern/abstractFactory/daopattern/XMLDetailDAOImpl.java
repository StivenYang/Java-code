package top.hengshare.interview.pattern.abstractFactory.daopattern;

public class XMLDetailDAOImpl implements OrderDetailDAO {
	@Override
	public void saveOrderDetail() {
		System.out.println("使用：XMLDetailDAOImpl");
	}
}
