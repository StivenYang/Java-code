package top.hengshare.interview.pattern.memento.struct;

/**
 * @program: Java-Interview
 * @description: 源发器对象
 * @author: Steven Yang
 * @create: 2019-10-18 18:48
 **/
public class Originator {

	/**
	 * 模拟状态
	 */
	private String state = "";

	/**
	 * 创建备忘录
	 * @return
	 */
	public Memento createMemento() {
		return new MementoImpl(state);
	}

	/**
	 * 设置备忘录
	 * @param memento
	 */
	public void setMemento(Memento memento) {
		MementoImpl mementoImpl = (MementoImpl) memento;
		this.state = mementoImpl.getState();
	}

	/**
	 * 具体的备忘录实现，可以通过这个备忘录保存当前的状态
	 */
	private static class MementoImpl implements Memento {
		private String state = "";

		public MementoImpl(String state) {
			this.state = state;
		}

		public String getState() {
			return state;
		}
	}
}
