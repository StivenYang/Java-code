package top.hengshare.interview.algorithm.interview;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 令 s = "hfkfdlsahfgdiuanvzx"，试对 s 去重并按字母顺序排列
 * 输出 "adfghiklnsuvxz"；
 *
 * @author yjh
 * @since 2021/1/6 2:46 下午
 **/
public class SortString {

	public String sortString(String source) {
		String[] sourceArray = source.split("");
		TreeSet<String> targetSet = new TreeSet<>(Arrays.asList(sourceArray));
		StringBuilder targetString = new StringBuilder();
		for (String s : targetSet) {
			targetString.append(s);
		}
		return targetString.toString().trim();
	}

	public String sortStringNoTree(String source) {
		char[] targetArray = new char[26];
		String[] sourceArray = source.split("");
		for (String str : sourceArray) {
			char c = str.charAt(0);
			int index = c - 'a';
			targetArray[index] = c;
		}
		StringBuilder targetString = new StringBuilder();
		for (char c : targetArray) {
			if (c != 0) {
				targetString.append(c);
			}
		}
		return targetString.toString().trim();
	}
}
