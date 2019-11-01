package top.hengshare.interview.pattern.chainOfResposiblity.example;

/**
 * @program: Java-Interview
 * @description: 处理聚餐费用申请的对象
 * @author: StivenYang
 * @create: 2019-10-31 21:48
 **/
public class FeeRequest {
    public String requestToProjectManager(String user, double fee){
        String str = "";
        if (fee < 500) {
            //项目经历的权限比较小，只能在500以内
            str = this.projectHandler(user, fee);
        } else if (fee < 1000) {
            //部门经历的权限只能在1000之内
            str = this.depManagerHandler(user, fee);
        } else if (fee >= 1000) {
            //总经理的权限很大，只要请求到了这里，他都可以处理
            str = this.generalManagerHandler(user, fee);
        }

        return str;
    }

    private String generalManagerHandler(String user, double fee) {
        String str = "";
        if ("小李".equals(user)) {
            str = "总经理同意" + user + "聚餐费用" + fee + "元的请求";
        }else {
            //其他人的都不同意
            str = "总经理不同意" + user + "聚餐费用" + fee + "元的请求";
        }
        return str;
    }

    private String depManagerHandler(String user, double fee) {
        String str = "";
        if ("小李".equals(user)) {
            str = "部门经理同意" + user + "聚餐费用" + fee + "元的请求";
        }else {
            //其他人的都不同意
            str = "部门经理不同意" + user + "聚餐费用" + fee + "元的请求";
        }
        return str;
    }

    private String projectHandler(String user, double fee) {
        String str = "";
        //为了测试，简单点，只同意小李的
        if ("小李".equals(user)) {
            str = "项目经理同意" + user + "聚餐费用" + fee + "元的请求";
        }else {
            //其他人的都不同意
            str = "项目经理不同意" + user + "聚餐费用" + fee + "元的请求";
        }
        return str;
    }


}
