package top.hengshare.interview.pattern.abstractFactory.daopattern;

public class BussinessObject {
    public static void main(String[] args) {
        //创建rdbdao工厂
        DAOFactory daoFactory = new RdbDAOFactory();
        OrderDetailDAO orderDetailDAO = daoFactory.createOrderDetailDAO();
        OrderMainDAO orderMainDAO = daoFactory.createOrderMainDAO();
        orderDetailDAO.saveOrderDetail();
        orderMainDAO.saveOrderMain();

        //创建xmldao工厂
        daoFactory = new XMLDAOFactory();
        OrderDetailDAO orderDetailDAO1 = daoFactory.createOrderDetailDAO();
        OrderMainDAO orderMainDAO1 = daoFactory.createOrderMainDAO();
        orderDetailDAO1.saveOrderDetail();
        orderMainDAO1.saveOrderMain();
    }
}
