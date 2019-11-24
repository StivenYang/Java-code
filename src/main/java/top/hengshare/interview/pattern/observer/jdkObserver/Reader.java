package top.hengshare.interview.pattern.observer.jdkObserver;

import lombok.Getter;
import lombok.Setter;

import java.util.Observable;
import java.util.Observer;

public class Reader implements Observer {

    @Getter
    @Setter
    private String name;

    @Override
    public void update(Observable o, Object arg) {
        //这是推的模式
        System.out.println(name+"收到推送消息了："+ arg);
        //这是拉的模式
        System.out.println(name+"收到推送消息了："+((Newspaper)o).getContent());
    }
}
