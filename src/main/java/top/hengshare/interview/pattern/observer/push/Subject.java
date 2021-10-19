package top.hengshare.interview.pattern.observer.push;

import com.google.common.collect.Lists;

import java.util.List;

public class Subject {
	private List<Observer> readers = Lists.newArrayList();

	public void attach(Observer observer) {
		readers.add(observer);
	}

	public void detach(Observer observer) {
		readers.remove(observer);
	}

	protected void notifyObservers(String content) {
		for (Observer reader : readers) {
			//推模式 和 拉模式 主要是这里不同。
			//推模式传递的是具体的内容，直接把内容推过去了
			//拉模式传递的是subject（发布者），需要在具体的发布者对象中拉取具体的内容
			reader.update(content);
		}
	}
}
