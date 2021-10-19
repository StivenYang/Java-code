package top.hengshare.interview.pattern.decorator.example;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @program: Java-Interview
 * @description: TempDB
 * @author: StivenYang
 * @create: 2019-10-31 15:03
 **/
public class TempDB {
	private TempDB() {
	}

	/**
	 * 记录每个人的月度销售额，只用了人员，月份没有用
	 */
	public static Map<String, Double> mapMonthSaleMoney = Maps.newHashMap();

	static {
		//填充测试数据
		mapMonthSaleMoney.put("张三", 10000.0);
		mapMonthSaleMoney.put("李四", 20000.0);
		mapMonthSaleMoney.put("王五", 30000.0);

	}
}
