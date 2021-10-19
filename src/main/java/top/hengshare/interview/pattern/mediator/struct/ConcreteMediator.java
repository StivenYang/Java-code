package top.hengshare.interview.pattern.mediator.struct;

public class ConcreteMediator implements Mediator {

	/**
	 * 持有并维护同事a
	 */
	private ConcreteColleagueA colleagueA;

	/**
	 * 持有并维护同事B
	 */
	private ConcreteColleagueB colleagueB;

	/**
	 * 设置中介者需要了解并维护的同事A
	 * @param colleagueA
	 */
	public void setColleagueA(ConcreteColleagueA colleagueA) {
		this.colleagueA = colleagueA;
	}

	/**
	 * 设置中介者需要了解并维护的同事B
	 * @param colleagueB
	 */
	public void setColleagueB(ConcreteColleagueB colleagueB) {
		this.colleagueB = colleagueB;
	}

	/**
	 *
	 * @param colleague
	 */
	@Override
	public void changed(Colleague colleague) {
		//某个同事类发生了变化，通常需要与其他同事交互
		//具体协调相应的同事对象来实现协作行为
	}
}
