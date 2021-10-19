package top.hengshare.interview.pattern.iterator.javaIterator;

import java.util.Iterator;

public class Client {
	public static void main(String[] args) {
		//访问集团的工资列表
		PayManager payManager = new PayManager();
		//先计算再获取
		payManager.calcPay();
		System.out.println("集团工资列表:");
		test(payManager.createIterator());

		//访问新收购公司的工资列表
		SalaryManager salaryManager = new SalaryManager();
		salaryManager.calcSalary();
		System.out.println("新收购公司的工资列表:");
		test(salaryManager.createIterator());
	}

	private static void test(Iterator iterator) {
		while (iterator.hasNext()) {
			Object o = iterator.next();
			System.out.println(o);
		}
	}
}
