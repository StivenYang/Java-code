package top.hengshare.interview.pattern.iterator.randomIterator;

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
	public boolean hasPrevious() {
		if (pms != null && index > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Collection getPage(int pageNum, int pageShow) {
		Collection col = Lists.newArrayList();
		int start = (pageNum - 1) * pageShow;
		int end = start + pageShow - 1;
		if (start < 0) {
			start = 0;
		}
		if (end > pms.length - 1) {
			end = pms.length - 1;
		}
		index = 0;
		while (hasNext() && index <= end) {
			if (index >= start) {
				col.add(pms[index]);
			}
			index++;
		}
		return col;
	}

}
