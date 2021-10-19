package top.hengshare.interview.pattern.abstractFactory.daopattern;

public class XMLDAOFactory implements DAOFactory {
	@Override
	public OrderDetailDAO createOrderDetailDAO() {
		return new XMLDetailDAOImpl();
	}

	@Override
	public OrderMainDAO createOrderMainDAO() {
		return new XMLMainDAOImpl();
	}
}
