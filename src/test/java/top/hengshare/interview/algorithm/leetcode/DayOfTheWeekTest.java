package top.hengshare.interview.algorithm.leetcode;

import org.junit.Test;

import java.time.LocalDate;

public class DayOfTheWeekTest {

    @Test
    public void dayOfTheWeek() {
        System.out.println(new DayOfTheWeek().dayOfTheWeek(
                LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(),
                LocalDate.now().getYear()));
    }
}