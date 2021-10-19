package top.hengshare.interview.pattern.mediator.struct;

/**
 * 具体的同事A
 */
public class ConcreteColleagueB extends Colleague {
	/**
	 * 构造方法，传入中介者对象
	 *
	 * @param mediator
	 */
	public ConcreteColleagueB(Mediator mediator) {
		super(mediator);
	}

	/**
	 * 执行某些业务功能
	 */
	public void someOperation() {
		//在需要和其他同事通信的时候，通知中介者对象
		getMediator().changed(this);
	}
}
