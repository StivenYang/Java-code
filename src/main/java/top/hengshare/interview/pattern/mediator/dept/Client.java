package top.hengshare.interview.pattern.mediator.dept;

public class Client {
    public static void main(String[] args) {
        DepUserMediatorImpl mediator = DepUserMediatorImpl.getInstance();

        //准备要撤销的部门
        Dep dep = new Dep();
        dep.setDepId("d1");
        Dep dep2 = new Dep();
        dep2.setDepId("d2");

        //准备要离职的人员
        User user = new User();
        user.setUserId("u1");

        //查看撤销部门中有哪些人员
        System.out.println("撤销部门前：=============");
        mediator.showUserDep(user);
        //撤销部门
        dep.deleteDep();
        //再次查看人员所属的部门
        System.out.println("撤销部门后：==========");
        mediator.showUserDep(user);

        System.out.println("------------------------------");
        //测试人员离职
        System.out.println("人员离职前：============");
        mediator.showDepUser(dep2);
        //离职
        user.dimission();
        System.out.println("人员离职后：================");
        mediator.showDepUser(dep2);
    }
}
