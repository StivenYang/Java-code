package top.hengshare.interview.pattern.abstractFactory.daopattern;

public interface DAOFactory {
    OrderDetailDAO createOrderDetailDAO();
    OrderMainDAO createOrderMainDAO();
}
