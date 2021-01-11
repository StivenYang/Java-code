package top.hengshare.interview.algorithm.interview;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 删除字符串中重复字符，维持字符顺序
 *
 * @author yjh
 * @date 2021/1/10 6:33 下午
 **/
public class RemoveStringDump {

    public String removeStringDump(String source) throws Exception{
        if (source == null) {
            throw new Exception("source can not be null");
        }

        String[] sourceArray = source.split("");

        Set<String> targetSet = new LinkedHashSet<>(Arrays.asList(sourceArray));
        StringBuilder target = new StringBuilder();
        for (String s : targetSet) {
            target.append(s);
        }
        return target.toString();
    }
}
