package top.hengshare.interview.pattern.proxy.protectProxy;

public interface OrderAPI {
    String getProductName();
    void setProductName(String productName, String user);
    int getOrderNum();
    void setOrderNum(int orderNum, String user);
    String getOrderUser();
    void setOrderUser(String orderUser, String user);
}
