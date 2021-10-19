package top.hengshare.interview.pattern.iterator.iterExample;

/**
 * 迭代器接口
 */
public interface Iterator {
	void first();

	void next();

	boolean isDone();

	Object currentItem();
}
