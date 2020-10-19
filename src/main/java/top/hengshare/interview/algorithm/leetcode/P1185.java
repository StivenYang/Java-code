package top.hengshare.interview.algorithm.leetcode;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * P1185 一周中的第几天
 *
 * @author v_yangjiaheng_dxm
 * @date 2020/10/17 12:08 下午
 **/
public class P1185 {
    public static String dayOfTheWeek(int day, int month, int year) {
        if (month == 1 | month == 2) {
            month += 12;
            year--;
        }
        int iWeek = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
        String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        return weeks[iWeek];
    }

    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(LocalDate.now().getDayOfMonth(), LocalDate.now().getMonthValue(), LocalDate.now().getYear()));
    }
}
