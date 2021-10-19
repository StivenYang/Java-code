package top.hengshare.interview.pattern.visitor.example;

import com.google.common.collect.Lists;

import java.util.Collection;

/**
 * @program: Java-Interview
 * @description: Client
 * @author: StivenYang
 * @create: 2019-11-03 19:25
 **/
public class Client {
	public static void main(String[] args) {
		//准备测试数据
		Collection<Customer> customerCollection = preparedTestData();
		//循环对客户进行操作
		for (Customer customer : customerCollection) {
			//进行偏好分析
			customer.predilectionAnalyze();
			//进行价值分析
			customer.worthAnalyze();
		}
	}

	private static Collection<Customer> preparedTestData() {
		Collection<Customer> customerCollection = Lists.newArrayList();

		//为了测试方便，准备测试数据
		EnterpriseCustomner enterpriseCustomner = new EnterpriseCustomner();
		enterpriseCustomner.setName("ABC集团");
		customerCollection.add(enterpriseCustomner);

		EnterpriseCustomner enterpriseCustomner1 = new EnterpriseCustomner();
		enterpriseCustomner1.setName("CDE集团");
		customerCollection.add(enterpriseCustomner1);

		PersonalCustomer personalCustomer = new PersonalCustomer();
		personalCustomer.setName("张三");
		customerCollection.add(personalCustomer);

		return customerCollection;
	}
}
