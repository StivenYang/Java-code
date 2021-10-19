package top.hengshare.interview.pattern.iterator.javaIterator;

import java.util.Iterator;

/**
 * 聚合对象的父类
 */
public abstract class Aggregate {

	public abstract Iterator createIterator();

	public abstract int size();

	public abstract Object get(int index);
}
