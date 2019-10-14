package top.hengshare.interview.pattern.observer.struct;

/**
 * 具体的观察者
 */
public class ConcreteObserver1 implements Observer {

    private String observerState;

    @Override
    public void update(Subject subject) {
        observerState = ((ConcreteSubject)subject).getSubjectState();
    }
}
