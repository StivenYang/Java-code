package top.hengshare.interview.pattern.flyweight.sharedFlyweight;

import com.google.common.collect.Lists;

import java.util.Collection;

/**
 * @program: Java-Interview
 * @description: testdb
 * @author: StivenYang
 * @create: 2019-10-22 14:15
 **/
public class TestDB {
	public static Collection<String> colDB = Lists.newArrayList();

	static {
		//通过静态快来填充模拟的数据
		colDB.add("张三,人员列表,查看");
		colDB.add("李四,人员列表,查看");
		colDB.add("李四,薪资数据,查看");
		colDB.add("李四,薪资数据,修改");
		//增加更多的授权数据
		for (int i = 0; i < 3; i++) {
			colDB.add("张三" + i + ",人员列表,查看");
		}
	}
}
