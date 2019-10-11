package top.hengshare.interview.pattern.mediator.dept;

import com.google.common.collect.Lists;

import java.util.Collection;

public class DepUserMediatorImpl {

    private static DepUserMediatorImpl mediator = new DepUserMediatorImpl();

    /**
     * 只能通过单例获取，不可被构造
     */
    private DepUserMediatorImpl() {
        initTestData();
    }

    /**
     * 部门、用户表的数据集
     */
    private Collection<DepUserModel> depUserCol = Lists.newArrayList();

    /**
     * 初始化测试数据
     */
    private void initTestData() {
        DepUserModel du1 = new DepUserModel();
        du1.setDepUserId("du1");
        du1.setDepId("d1");
        du1.setUserId("u1");
        depUserCol.add(du1);

        DepUserModel du2 = new DepUserModel();
        du2.setDepUserId("du2");
        du2.setDepId("d1");
        du2.setUserId("u2");
        depUserCol.add(du2);

        DepUserModel du3 = new DepUserModel();
        du3.setDepUserId("du3");
        du3.setDepId("d2");
        du3.setUserId("u3");
        depUserCol.add(du3);

        DepUserModel du4 = new DepUserModel();
        du4.setDepUserId("du4");
        du4.setDepId("d2");
        du4.setUserId("u4");
        depUserCol.add(du4);

        DepUserModel du5 = new DepUserModel();
        du5.setDepUserId("du5");
        du5.setDepId("d2");
        du5.setUserId("u1");
        depUserCol.add(du5);
    }

    /**
     * 饿汉单例模式，提供中介者对象
     *
     * @return
     */
    public static DepUserMediatorImpl getInstance() {
        return mediator;
    }

    /**
     * 完成部门解散的业务
     *
     * @param depId
     * @return
     */
    public boolean deleteDep(String depId) {
        //为了演示简单，部门撤销后，原部门的人员怎么处理就不管了

        //新建一个临时的集合，记录需要删除的关系对象
        Collection<DepUserModel> tempCol = Lists.newArrayList();
        for (DepUserModel model : depUserCol) {
            if (model.getDepId().equals(depId)) {
                tempCol.add(model);
            }
        }
        //删除满足条件的对象
        depUserCol.removeAll(tempCol);

        return true;
    }

    public boolean deleteUser(String userId) {
        //到中间表查找与该用户有关的部门放入集合
        Collection<DepUserModel> tempCol = Lists.newArrayList();

        for (DepUserModel depUserModel : depUserCol) {
            if (depUserModel.getUserId().equals(userId)) {
                tempCol.add(depUserModel);
            }
        }

        depUserCol.removeAll(tempCol);

        return true;
    }

    /**
     * 显示一个部门下的所有用户
     *
     * @param dep
     */
    public void showDepUser(Dep dep) {
        for (DepUserModel depUserModel : depUserCol) {
            if (depUserModel.getDepId().equals(dep.getDepId())) {
                System.out.println("部门编号=" + dep.getDepId() + "下面拥有人员编号有：" + depUserModel.getUserId());
            }
        }
    }

    /**
     * 显示某个用户所属部门
     *
     * @param user
     */
    public void showUserDep(User user) {
        for (DepUserModel depUserModel : depUserCol) {
            if (depUserModel.getUserId().equals(user.getUserId())) {
                System.out.println("人员" + user.getUserName() + ",编号为：" + user.getUserId() + "所属部门编号有：" + depUserModel.getDepId());
            }
        }
    }

    /**
     * 完成因人员调换部门引起的与部门之间的交互
     *
     * @param userId
     * @param oldDepId
     * @param newDeptId
     * @return
     */
    public boolean changeDep(String userId, String oldDepId, String newDeptId) {
        //todo
        return false;
    }

    /**
     * 完成部门合并所引起的与人员的交互
     * @param colDepIds
     * @param newDep
     * @return
     */
    public boolean joinDep(Collection<String> colDepIds, Dep newDep) {
        //todo
        return false;
    }
}
