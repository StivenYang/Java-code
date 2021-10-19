package top.hengshare.interview.algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * P973 最接近原点的K个点
 *
 * @author v_yangjiaheng_dxm
 * @date 2020/11/9 6:15 下午
 **/
public class KClosest {

	static int[][] points = new int[][]{{3, 3}, {5, -1}, {-2, 4}};

	public static int[][] kClosest(int[][] points, int K) {
		Arrays.sort(points, Comparator.comparingInt(pointer -> (pointer[0] * pointer[0] + pointer[1] * pointer[1])));
		return Arrays.copyOfRange(points, 0, K);
	}

	public static void main(String[] args) {
		//        Arrays.stream(kClosest(points, 2)).forEach(o -> System.out.println(Arrays.toString(o)));
		Arrays.stream(kClosest1(points, 2)).forEach(o -> System.out.println(Arrays.toString(o)));
	}

	public static int[][] kClosest1(int[][] points, int K) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr2[0] - arr1[0]);
		for (int i = 0; i < K; i++) {
			pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
		}
		for (int i = K; i < points.length; i++) {
			int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
			if (pq.size() > 0 && dist < pq.peek()[0]) {
				pq.poll();
				pq.offer(new int[]{dist, i});
			}
		}
		int[][] result = new int[K][2];
		for (int i = 0; i < K; i++) {
			if (pq.size() > 0) {
				result[i] = points[pq.poll()[1]];
			}
		}
		return result;
	}

	//    public static int[][] kClosest2(int[][] points, int K) {
	//
	//    }
}
