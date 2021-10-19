package top.hengshare.interview.algorithm.sort;

/**
 * Quick 快速排序
 *
 * @author yangjiaheng
 * @date 2020/7/10 1:52 下午
 **/
public class Quick {

	public void sort(int[] arr, int left, int right) {
		if (left >= right)
			return;
		// 小于分界点元素的最右侧的指针
		int lo = left + 1;
		// 大于分界点元素的最左侧的指针
		int hi = right;
		while (lo <= hi) {
			// 交换元素确保左侧指针指向元素小于分界点元素
			if (arr[lo] > arr[left]) {
				swap(arr, lo, hi);
				hi--;
			} else {
				lo++;
			}
		}
		// 回到小于分界点元素数组的最右侧
		lo--;
		// 将分界点元素移到左侧数组最右侧
		swap(arr, left, lo);
		sort(arr, left, lo - 1);
		sort(arr, lo + 1, right);
	}

	public static void swap(int[] arr, int midPoint, int largestPoint) {
		int temp = arr[midPoint];
		arr[midPoint] = arr[largestPoint];
		arr[largestPoint] = temp;
	}
}
