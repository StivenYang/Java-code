package top.hengshare.interview.pattern.observer.struct;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 发布者类，维护观察者列表，在自身状态改变后，调用方法通知所有的观察者
 */
public class Subject {

    private List<Observer> observers = Lists.newArrayList();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}
