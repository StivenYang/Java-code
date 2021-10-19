package top.hengshare.interview.pattern.iterator.struct;

public class Client {
	public static void main(String[] args) {
		String[] names = {"张三", "李四", "王五"};

		//创建聚合对象
		ConcreteAggregate aggregate = new ConcreteAggregate(names);
		//循环输出聚合对象中的值
		Iterator iterator = aggregate.createIterator();
		//设置迭代器索引到第一个元素
		iterator.first();
		while (!iterator.isDone()) {
			//取出当前的元素
			Object obj = iterator.currentItem();
			System.out.println("the object == " + obj);
			//如果还没有迭代到最后，那么就向下迭代一个
			iterator.next();
		}

	}
}
