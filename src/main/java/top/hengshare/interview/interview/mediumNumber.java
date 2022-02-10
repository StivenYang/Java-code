package top.hengshare.interview.interview;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class mediumNumber {

	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 3, 3);

		System.out.println(find(arr));
	}

	public static Integer find(List<Integer> arr){
		long start = System.currentTimeMillis();
		if (arr.isEmpty()) {
			throw new RuntimeException();
		}
		HashMap<Integer, Integer> numMap = Maps.newHashMap();

		for (Integer curNum : arr) {
			if (numMap.containsKey(curNum)){
				Integer count = numMap.get(curNum);
				count = count + 1;
				numMap.put(curNum, count);
			}else {
				numMap.put(curNum, 1);
			}
		}

		Integer maxValue = arr.get(0);
		int max = numMap.get(arr.get(0));
		for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
			if (entry.getValue() > maxValue) {
				maxValue = entry.getValue();
				max = entry.getKey();
			}
		}

		System.out.println("花费时间：" + (System.currentTimeMillis()-start));
		return max;
	}
}
