package top.hengshare.interview.algorithm.sort;

/**
 * 冒泡排序
 *
 * @author yangjiaheng
 * @date 2020/6/23 5:49 下午
 **/
public class Bubble {

	/**
	 * 冒泡排序的原理是：先拿开头的一个数，然后再依次遍历这个数开始之后的数，进行比较，如果找最大值，那就是第一个数要大于其余的数，然后将大的数放到
	 * 开头，如果找最小的数，那就把最小的数放开头，完成就是按照最大或者最小顺序进行排序得了
	 *
	 * @param arr 数组
	 */
	public void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
