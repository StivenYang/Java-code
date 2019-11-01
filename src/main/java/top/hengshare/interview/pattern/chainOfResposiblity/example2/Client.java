package top.hengshare.interview.pattern.chainOfResposiblity.example2;

/**
 * @program: Java-Interview
 * @description: Client
 * @author: StivenYang
 * @create: 2019-11-01 09:10
 **/
public class Client {
    public static void main(String[] args) {
        //先要组装职责链
        GeneralManager generalManager = new GeneralManager();
        DepManager depManager = new DepManager();
        ProjectManager projectManager = new ProjectManager();

        projectManager.setSuccessor(depManager);
        depManager.setSuccessor(generalManager);

        //开始测试
        System.out.println(projectManager.handleFeeRequest("小李", 300));
        System.out.println(projectManager.handleFeeRequest("小张", 300));

        System.out.println(projectManager.handleFeeRequest("小李", 800));
        System.out.println(projectManager.handleFeeRequest("小张", 800));

        System.out.println(projectManager.handleFeeRequest("小李", 1200));
        System.out.println(projectManager.handleFeeRequest("小张", 1200));

        //测试申请差旅费用
        projectManager.handlePreRequest("小张", 3000);
        projectManager.handlePreRequest("小张", 6000);
        projectManager.handlePreRequest("小张", 12000);
    }
}
