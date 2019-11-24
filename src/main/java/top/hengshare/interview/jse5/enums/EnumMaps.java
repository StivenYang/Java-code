package top.hengshare.interview.jse5.enums;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static top.hengshare.interview.jse5.enums.AlarmPoints.*;
import static top.hengshare.interview.utils.net.util.Print.*;

/**
 * @program: Java-Interview
 * @description: EnumMaps
 * @author: StivenYang
 * @create: 2019-11-21 23:29
 **/
public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        em.put(KITCHEN, new Command() {
            @Override
            public void action() {
                print("厨房着火啦！");
            }
        });
        em.put(BATHROOM, new Command() {
            @Override
            public void action() {
                print("卧室闹铃响了！");
            }
        });
        for (Map.Entry<AlarmPoints, Command> entry : em.entrySet()) {
            printnb(entry.getKey() + ": ");
            entry.getValue().action();
        }
        try {
            em.get(UTILITY).action();
        } catch (Exception e) {
            print(e);
        }
    }
}

interface Command {
    void action();
}
