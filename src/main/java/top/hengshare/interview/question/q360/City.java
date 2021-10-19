package top.hengshare.interview.question.q360;

import java.util.Scanner;

/**
 * 有一个城市需要修建，给你N个民居的坐标X,Y，问把这么多民居全都包进城市的话，城市所需最小面积是多少（注意，城市为平行于坐标轴的正方形）
 */
public class City {

	public static void main(String[] args) {
		System.out.println("输入人数：");
		Scanner scanner = new Scanner(System.in);
		Integer count = Integer.valueOf(scanner.nextLine());
		System.out.println("输入对应的x y坐标（用空格隔开）：");
		for (int i = 0; i < count; i++) {
		}
	}

}

class People {
	private double x;
	private double y;

	public People(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
