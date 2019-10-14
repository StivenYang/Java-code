package top.hengshare.interview.pattern.observer.struct;

/**
 * 观察者的接口，更新自己的状态
 */
public interface Observer {
    void update(Subject subject);
}
