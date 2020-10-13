package top.hengshare.interview.algorithm.leetcode;

/**
 * P1710
 *
 * @author yangjiaheng
 * @date 2020/10/13 7:43 下午
 **/
public class P1710 {
    public static int majorityElement(int[] nums) {
        if (nums.length == 0) return -1;
        int count = 1;
        int temp = nums[0];
        for (int i=1; i<nums.length;i++){
            if (nums[i] == temp) {
                count++;
            }else {
                count--;
            }
            if (count == 0) {
                temp = nums[i];
                count=1;
            }
        }
        count = 0;
        int len  = nums.length /2 +1;
        for (int num : nums){
            if (num == temp) count++;
            if (count == len) return temp;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,5,5,5,5};
        System.out.println(majorityElement(arr));
    }
}
