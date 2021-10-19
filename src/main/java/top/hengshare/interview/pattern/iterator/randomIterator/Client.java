package top.hengshare.interview.pattern.iterator.randomIterator;

import java.util.Collection;

public class Client {
	public static void main(String[] args) {
		SalaryManager salaryManager = new SalaryManager();
		salaryManager.calcSalary();

		AggregationIterator iterator = salaryManager.createIterator();

		//获取第一页显示2条
		Collection page = iterator.getPage(1, 2);
		System.out.println("获取第1页，每页2条记录：");
		print(page);

		//获取第二页，每页3条
		Collection page1 = iterator.getPage(2, 3);
		System.out.println("获取第2页，每页3条记录：");
		print(page1);

	}

	private static void print(Collection page) {
		for (Object o : page) {
			System.out.println(o);
		}
	}
}
