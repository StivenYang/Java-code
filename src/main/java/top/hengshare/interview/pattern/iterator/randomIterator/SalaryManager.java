package top.hengshare.interview.pattern.iterator.randomIterator;

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

		PayModel payModel2 = new PayModel();
		payModel2.setUserName("赵六");
		payModel2.setPay(3760);

		PayModel payModel3 = new PayModel();
		payModel3.setUserName("赵六");
		payModel3.setPay(3450);

		PayModel payModel4 = new PayModel();
		payModel4.setUserName("赵六");
		payModel4.setPay(3230);

		payModels = new PayModel[5];
		payModels[0] = payModel;
		payModels[1] = payModel1;
		payModels[2] = payModel2;
		payModels[3] = payModel3;
		payModels[4] = payModel4;

	}

	@Override
	public AggregationIterator createIterator() {
		return new ArrayIteratorImpl(this);
	}
}
