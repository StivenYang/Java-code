package top.hengshare.interview.algorithm;

import com.google.common.collect.Maps;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 8};

        int[] index = getIndex(10, arr);
        for (int i : index) {
            System.out.println(i);
        }
    }

    public static int[] getIndex(int target, int[] arr) {
        HashMap<Integer, Integer> indexs = Maps.newHashMap();
        for (int i = 0; i < arr.length; i++) {
            indexs.put(arr[i], i);
            if (indexs.containsKey(target - arr[i])) {
                return new int[]{i, indexs.get(target - arr[i])};
            }
        }

        return new int[]{};
    }
}