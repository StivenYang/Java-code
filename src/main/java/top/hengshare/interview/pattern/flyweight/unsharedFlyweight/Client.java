package top.hengshare.interview.pattern.flyweight.unsharedFlyweight;

/**
 * @program: Java-Interview
 * @description: test
 * @author: StivenYang
 * @create: 2019-10-22 14:32
 **/
public class Client {
    public static void main(String[] args) {
        //先登陆，再判断权限
        SecurityMgr securityMgr = SecurityMgr.getInstance();
        securityMgr.login("张三");
        securityMgr.login("李四");
        boolean f1 = securityMgr.hasPermit("张三", "薪资数据", "查看");
        boolean f2 = securityMgr.hasPermit("李四", "薪资数据", "查看");
        boolean f3 = securityMgr.hasPermit("李四", "薪资数据", "修改");


        System.out.println("f1=="+ f1);
        System.out.println("f2=="+ f2);
        System.out.println("f3=="+ f3);

        for (int i = 0; i< 3; i++){
            securityMgr.login("张三"+i);
            securityMgr.hasPermit("张三"+i, "薪资数据", "查看");
        }
    }
}
