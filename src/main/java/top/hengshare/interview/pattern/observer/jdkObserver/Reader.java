package top.hengshare.interview.pattern.observer.jdkObserver;

import java.util.Observable;
import java.util.Observer;

public class Reader implements Observer {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {
        //这是推的模式
        System.out.println(name+"收到推送消息了："+ arg);
        //这是拉的模式
        System.out.println(name+"收到推送消息了："+((Newspaper)o).getContent());
    }
}
