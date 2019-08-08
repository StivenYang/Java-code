package top.hengshare.interviewer.thread.concurrency.ThreadPoolDemo;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

import javax.annotation.PostConstruct;

/**
 * 线程池，注册task类
 */
@Component
public class Factory {

    private static List<Indexalculation> indexalculations = Lists.newArrayList();

    @PostConstruct
    public void init() {
        // 注册所有的计算逻辑类到set里
        indexalculations.add(new Index1());
    }

    public static List<Indexalculation> getIndexalculations() {
        indexalculations.add(new Index1());
        return indexalculations;
    }
}
