package top.hengshare.interview.schedule;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时执行任务
 */
public class ScheduleTaskTest {
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("123");
            }
        }, Date.from(LocalDateTime.of(2019, 9,3,14, 33).atZone(ZoneId.systemDefault()).toInstant()));
    }
}
