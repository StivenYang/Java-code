package top.hengshare.interview.pattern.abstractFactory.daopattern;

public class XMLMainDAOImpl implements OrderMainDAO {
	@Override
	public void saveOrderMain() {
		System.out.println("使用：XMLMainDAOImpl");
	}
}
