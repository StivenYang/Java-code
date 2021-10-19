package top.hengshare.interview.algorithm.leetcode;

/**
 * P605 种花问题
 *
 * @author v_yangjiaheng_dxm
 * @date 2020/10/17 10:02 上午
 **/
public class CanPlaceFlowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (n == 0)
			return true;
		if (flowerbed.length == 1 && flowerbed[0] == 0 && n == 1)
			return true;
		if (flowerbed.length == 1 && flowerbed[0] == 1)
			return false;
		if (n > flowerbed.length / 2 + 1)
			return false;

		int count = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 1)
				continue;

			if ((i == 0 && flowerbed[i + 1] == 0) || (i == flowerbed.length - 1 && flowerbed[i - 1] == 0) || (i != 0
					&& i != flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)) {
				flowerbed[i] = 1;
				count++;
			}

			if (count >= n) {
				return true;
			}
		}
		return false;
	}
}
