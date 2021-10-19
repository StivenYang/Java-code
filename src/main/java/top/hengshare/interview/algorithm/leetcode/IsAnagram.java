package top.hengshare.interview.algorithm.leetcode;

import java.util.Arrays;

/**
 * 是否是有效的字母异位词
 *
 * @author StevenYang
 * @since 2020/7/19
 **/
public class IsAnagram {

	public boolean isAnatram1(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] arr1 = s.toCharArray();
		char[] arr2 = t.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		return Arrays.equals(arr1, arr2);
	}

	public boolean isAnatram2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] counter = new int[26];
		for (int i = 0; i < s.length(); i++) {
			counter[s.charAt(i) - 'a']++;
			counter[t.charAt(i) - 'a']--;
		}
		for (int count : counter) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isAnatram3(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] table = new int[26];
		for (int i = 0; i < s.length(); i++) {
			table[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			table[t.charAt(i) - 'a']--;
			if (table[t.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}
}
