package top.hengshare.interview.pattern.abstractFactory.daopattern;

public class RdbDAOFactory implements DAOFactory {
    @Override
    public OrderDetailDAO createOrderDetailDAO() {
        return new RdbDetailDAOImpl();
    }

    @Override
    public OrderMainDAO createOrderMainDAO() {
        return new RdbMainDAOImpl();
    }
}
