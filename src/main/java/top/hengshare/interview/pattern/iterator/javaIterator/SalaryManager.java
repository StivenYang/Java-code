package top.hengshare.interview.pattern.iterator.javaIterator;

import java.util.Iterator;

public class SalaryManager extends Aggregate {
	private PayModel[] payModels;

	public PayModel[] getPayModels() {
		return payModels;
	}

	public void calcSalary() {
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

	@Override
	public Iterator createIterator() {
		return new ArrayIteratorImpl(this);
	}

	@Override
	public int size() {
		return payModels.length;
	}

	@Override
	public Object get(int index) {
		return payModels[index];
	}
}
