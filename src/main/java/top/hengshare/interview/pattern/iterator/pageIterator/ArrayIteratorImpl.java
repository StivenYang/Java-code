package top.hengshare.interview.pattern.iterator.pageIterator;

import com.google.common.collect.Lists;

import java.util.Collection;

public class ArrayIteratorImpl implements AggregationIterator {

	private PayModel[] pms = null;

	private int index = 0;

	public ArrayIteratorImpl(SalaryManager aggregate) {
		this.pms = aggregate.getPayModels();
	}

	@Override
	public boolean hasNext() {
		if (pms != null && index <= pms.length - 1) {
			return true;
		}
		return false;
	}

	@Override
	public Collection next(int num) {
		Collection col = Lists.newArrayList();
		int count = 0;
		while (hasNext() && count < num) {
			col.add(pms[index]);
			index++;
			count++;
		}
		return col;
	}

	@Override
	public boolean hasPrevious() {
		if (pms != null && index > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Collection previous(int num) {
		Collection col = Lists.newArrayList();
		int count = 0;
		index = index - num;
		while (hasPrevious() && count < num) {
			col.add(pms[index]);
			index++;
			count++;
		}
		return col;
	}
}
