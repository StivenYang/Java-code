package top.hengshare.interview.pattern.observer.example;

import com.google.common.collect.Lists;

import java.util.List;

public abstract class WaterQualitySubject {

	protected List<WaterObserver> watchers = Lists.newArrayList();

	public void attach(WaterObserver observer) {
		watchers.add(observer);
	}

	public void detach(WaterObserver observer) {
		watchers.remove(observer);
	}

	public abstract void notifyWatchers();

	public abstract int getPolluteLevel();
}
