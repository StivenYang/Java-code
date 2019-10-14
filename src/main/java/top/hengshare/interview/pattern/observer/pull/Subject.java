package top.hengshare.interview.pattern.observer.pull;

import com.google.common.collect.Lists;
import java.util.List;

public class Subject {
    private List<Observer> readers = Lists.newArrayList();

    public void attach(Observer observer){
        readers.add(observer);
    }

    public void detach(Observer observer){
        readers.remove(observer);
    }

    protected void notifyObservers(){
        for (Observer reader : readers) {
            //拉模式这里传递的是发布者的引用，然后在订阅者的update方法中拉取具体的数据内容
            //推模式直接传送要推送的数据过去，不需要再次拉取
            reader.update(this);
        }
    }
}
