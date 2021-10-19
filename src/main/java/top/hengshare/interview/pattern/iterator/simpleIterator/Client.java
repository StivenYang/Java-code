package top.hengshare.interview.pattern.iterator.simpleIterator;

import java.util.List;

public class Client {
	public static void main(String[] args) {
		//访问集团的工资列表
		PayManager payManager = new PayManager();
		//先计算再获取
		payManager.calcPay();
		List<PayModel> list = payManager.getList();
		System.out.println("集团工资列表:");
		for (PayModel payModel : list) {
			System.out.println(payModel);
		}

		//访问新收购公司的工资列表
		SalaryManager salaryManager = new SalaryManager();
		salaryManager.calcSalary();
		PayModel[] payModels = salaryManager.getPayModels();
		System.out.println("新收购公司的工资列表:");
		for (PayModel payModel : payModels) {
			System.out.println(payModel);
		}
	}
}
