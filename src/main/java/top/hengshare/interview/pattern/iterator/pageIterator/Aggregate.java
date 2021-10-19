package top.hengshare.interview.pattern.iterator.pageIterator;

/**
 * 聚合对象的父类
 */
public abstract class Aggregate {

	public abstract AggregationIterator createIterator();

	public abstract int size();

	public abstract Object get(int index);
}
