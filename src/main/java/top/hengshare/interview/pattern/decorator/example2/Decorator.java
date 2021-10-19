package top.hengshare.interview.pattern.decorator.example2;

import java.util.Date;

/**
 * @program: Java-Interview
 * @description: Decorator
 * @author: StivenYang
 * @create: 2019-10-31 15:49
 **/
public abstract class Decorator extends Component {

	/**
	 * 持有被装饰的组建的对象
	 */
	protected Component c;

	/**
	 * 构造装饰器方法
	 * @param c
	 */
	public Decorator(Component c) {
		this.c = c;
	}

	@Override
	public double calcPrize(String user, Date begin, Date end) {
		//转调组件对象的方法
		return c.calcPrize(user, begin, end);
	}
}
