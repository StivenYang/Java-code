package top.hengshare.interview.pattern.flyweight.gc;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;

/**
 * @program: Java-Interview
 * @description: testdb
 * @author: StivenYang
 * @create: 2019-10-22 14:15
 **/
public class TestDB {
    public static Collection<String> colDB = Lists.newArrayList();

    public static Map<String, String[]> mapDB = Maps.newHashMap();

    static {
        //通过静态快来填充模拟的数据
        //增加一个字段，用来表明是否组合授权数据
        colDB.add("张三,人员列表,查看,1");
        colDB.add("李四,人员列表,查看,1");
        colDB.add("李四,操作薪资数据,,2");
        colDB.add("李四,薪资数据,修改,1");

        //新增不需要共享
        mapDB.put("操作薪资数据", new String[]{"薪资数据,查看","薪资数据,修改"});

        //增加更多的授权数据
        for (int i = 0; i<3; i++){
            colDB.add("张三"+i+",人员列表,查看,1");
        }
    }
}
