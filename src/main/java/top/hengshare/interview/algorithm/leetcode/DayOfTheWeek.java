package top.hengshare.interview.algorithm.leetcode;

/**
 * P1185 一周中的第几天
 *
 * @author v_yangjiaheng_dxm
 * @date 2020/10/17 12:08 下午
 **/
public class DayOfTheWeek {
	public String dayOfTheWeek(int day, int month, int year) {
		if (month == 1 | month == 2) {
			month += 12;
			year--;
		}
		int iWeek = (day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400) % 7;
		String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

		return weeks[iWeek];
	}
}
