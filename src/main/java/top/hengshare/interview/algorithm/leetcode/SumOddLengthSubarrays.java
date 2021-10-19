package top.hengshare.interview.algorithm.leetcode;

/**
 * P1588
 *
 * @author v_yangjiaheng_dxm
 * @date 2020/10/13 10:28 下午
 **/
public class SumOddLengthSubarrays {
	public static int sumOddLengthSubarrays(int[] arr) {
		int res = 0;
		int len = arr.length;
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				if ((j - i) % 2 == 0) {
					for (int k = i; k <= j; k++) {
						res += arr[k];
					}
				}
			}
		}
		return res;
	}

	public static int sumOddLengthSubarrays1(int[] arr) {
		int res = 0;
		int len = arr.length;
		int[] preSum = new int[len + 1];
		preSum[0] = 0;
		for (int i = 1; i <= len; i++) {
			preSum[i] += preSum[i - 1] + arr[i - 1];
		}
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				if ((j - i) % 2 == 0) {
					res += preSum[j + 1] - preSum[i];
				}
			}
		}
		return res;
	}

	public static int sumOddLengthSubarrays2(int[] arr) {
		int len = arr.length, res = 0;
		for (int i = 0; i < len; i++) {
			int leftOdd = (i + 1) / 2, leftEven = i / 2 + 1;
			int rightOdd = (len - i) / 2, rightEven = (len - 1 - i) / 2 + 1;
			res += arr[i] * (leftOdd * rightOdd + leftEven * rightEven);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 4, 2, 5, 3};
		System.out.println(sumOddLengthSubarrays(arr));
		System.out.println(sumOddLengthSubarrays1(arr));
		System.out.println(sumOddLengthSubarrays2(arr));
	}
}
