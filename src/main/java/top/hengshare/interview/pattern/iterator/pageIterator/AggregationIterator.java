package top.hengshare.interview.pattern.iterator.pageIterator;

import java.util.Collection;

/**
 * 迭代器接口
 */
public interface AggregationIterator {
    boolean hasNext();
    Collection next(int num);
    boolean hasPrevious();
    Collection previous(int num);
}
