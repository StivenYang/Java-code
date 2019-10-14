package top.hengshare.interview.pattern.observer.jdkObserver;

import java.util.Observable;

public class Newspaper extends Observable {
    private String content;

    public void setContent(String content) {
        this.content = content;
        //这句话用来表明发布者内容改变
        this.setChanged();
        //下面这个是推的方式
        this.notifyObservers(this.content);
        //下面这个是拉的方式
//        this.notifyObservers();
    }

    public String getContent() {
        return content;
    }
}
