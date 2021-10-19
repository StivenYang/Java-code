package top.hengshare.interview.pattern.iterator.pageIterator;

import java.util.Collection;

public class Client {
	public static void main(String[] args) {

		//访问新收购公司的工资列表
		SalaryManager salaryManager = new SalaryManager();
		salaryManager.calcSalary();
		System.out.println("新收购公司的工资列表:");
		AggregationIterator iterator = salaryManager.createIterator();

		//获取第一页，每页显示两条
		Collection next = iterator.next(2);
		System.out.println("第一页数据：");
		print(next);
		Collection next1 = iterator.next(2);
		System.out.println("第二页数据：");
		print(next1);
		Collection next2 = iterator.next(2);
		System.out.println("第三页数据：");
		print(next2);

		//获取之前页数据
		Collection previous = iterator.previous(2);
		System.out.println("向前翻一页：");
		print(previous);
		Collection previous1 = iterator.previous(2);
		System.out.println("再向前翻一页：");
		print(previous1);
	}

	private static void print(Collection next) {
		for (Object o : next) {
			System.out.println(o);
		}
	}
}
