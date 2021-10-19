package top.hengshare.interview.pattern.iterator.randomIterator;

import java.util.Collection;

public interface AggregationIterator {
	boolean hasNext();

	boolean hasPrevious();

	Collection getPage(int pageNum, int pageShow);
}
