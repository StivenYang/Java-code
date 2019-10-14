package top.hengshare.interview.pattern.iterator.example;

import java.util.Iterator;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        //访问集团的工资列表
        PayManager payManager = new PayManager();
        //先计算再获取
        payManager.calcPay();
        List list = payManager.getList();
        Iterator iterator = list.iterator();
        System.out.println("集团工资列表:");
        while (iterator.hasNext()) {
            PayModel pm = (PayModel)iterator.next();
            System.out.println(pm);
        }

        //访问新收购公司的工资列表
        SalaryManager salaryManager = new SalaryManager();
        salaryManager.calcSalary();
        PayModel[] payModels = salaryManager.getPayModels();
        System.out.println("新收购公司的工资列表:");
        for (int i = 0; i < payModels.length; i++) {
            System.out.println(payModels[i]);
        }
    }
}
