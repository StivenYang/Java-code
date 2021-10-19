package top.hengshare.interview.jse5.enums;

import java.util.EnumSet;

import static top.hengshare.interview.jse5.enums.AlarmPoints.*;

/**
 * @program: Java-Interview
 * @description: EnumSets使用枚举Set来实现Set
 * @author: StivenYang
 * @create: 2019-11-21 23:12
 **/
public class EnumSets {

	public static void main(String[] args) {
		EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
		points.add(BATHROOM);
		points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
		System.out.println(points);
		points = EnumSet.allOf(AlarmPoints.class);
		points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
		System.out.println(points);
		points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
		System.out.println(points);
		points = EnumSet.complementOf(points);
		System.out.println(points);
	}
}

