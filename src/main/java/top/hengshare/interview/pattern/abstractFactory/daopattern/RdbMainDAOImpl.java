package top.hengshare.interview.pattern.abstractFactory.daopattern;

public class RdbMainDAOImpl implements OrderMainDAO {
	@Override
	public void saveOrderMain() {
		System.out.println("现在使用的是：RdbMainDAOImpl");
	}
}
