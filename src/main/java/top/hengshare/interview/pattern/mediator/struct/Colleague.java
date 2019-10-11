package top.hengshare.interview.pattern.mediator.struct;

/**
 * 同事类的抽象父类
 */
public abstract class Colleague {
    /**
     * 持有中介者对象，每个同事都知道中介是哪个
     */
    private Mediator mediator;

    /**
     * 构造方法，传入中介者对象
     * @param mediator
     */
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 获取中介者对象
     * @return
     */
    public Mediator getMediator() {
        return mediator;
    }
}
