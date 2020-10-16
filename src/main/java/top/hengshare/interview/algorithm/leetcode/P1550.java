package top.hengshare.interview.algorithm.leetcode;

/**
 * P1550 存在连续三个奇数的数组
 *
 * @author v_yangjiaheng_dxm
 * @date 2020/10/15 10:16 上午
 **/
public class P1550 {
    public static boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length < 3) return false;

        int temp = 0;
        while (temp < arr.length-2) {
            if (arr[temp] % 2 != 0) {
                if (arr[temp + 1] % 2 != 0) {
                    if (arr[temp + 2] % 2 != 0) {
                        return true;
                    } else {
                        temp = temp + 3;
                    }
                } else {
                    temp = temp + 2;
                }
            } else {
                temp = temp + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 4, 1};
        System.out.println(threeConsecutiveOdds(arr));
    }
}
