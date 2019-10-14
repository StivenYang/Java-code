package top.hengshare.interview.pattern.iterator.example;

public class SalaryManager {
    private PayModel[] payModels;

    public PayModel[] getPayModels() {
        return payModels;
    }

    public void calcSalary(){
        PayModel payModel = new PayModel();
        payModel.setPay(2200);
        payModel.setUserName("王五");

        PayModel payModel1 = new PayModel();
        payModel1.setUserName("赵六");
        payModel1.setPay(3600);

        payModels = new PayModel[2];
        payModels[0] = payModel;
        payModels[1] = payModel1;
    }
}
