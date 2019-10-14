package top.hengshare.interview.pattern.iterator.example;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 客户方已有的工资管理类
 */
public class PayManager {
    private List list = Lists.newArrayList();

    public List getList() {
        return list;
    }

    public void calcPay(){
        PayModel payModel = new PayModel();
        payModel.setPay(3800);
        payModel.setUserName("张三");

        PayModel payModel1 = new PayModel();
        payModel1.setUserName("李四");
        payModel1.setPay(5800);

        list.add(payModel);
        list.add(payModel1);
    }
}
