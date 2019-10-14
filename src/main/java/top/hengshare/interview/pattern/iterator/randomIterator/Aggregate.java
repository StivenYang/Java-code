package top.hengshare.interview.pattern.iterator.randomIterator;

/**
 * 聚合对象的父类
 */
public abstract class Aggregate {

    public abstract AggregationIterator createIterator();
}
