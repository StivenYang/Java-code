package top.hengshare.interview.algorithm.leetcode;

import java.util.*;

/**
 * P140 单词拆分二
 *
 * @author yjh
 * @since 2020/11/1
 */
public class WordBreakTwo {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<List<String>>> map = new HashMap<>();
        List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<>(wordDict), 0, map);
        List<String> breakList = new ArrayList<>();
        wordBreaks.forEach(list -> breakList.add(String.join(" ", list)));
        return breakList;
    }

    private static List<List<String>> backtrack(String s, int length, HashSet<String> wordDictSet, int index
            , Map<Integer, List<List<String>>> map) {
        if (!map.containsKey(index)) {
            List<List<String>> wordBreaks = new LinkedList<>();
            if (index == length) {
                wordBreaks.add(new LinkedList<>());
            }
            for (int i = index + 1; i <= length; i++) {
                String word = s.substring(index, i);
                if (wordDictSet.contains(word)) {
                    List<List<String>> nextWordBreaks = backtrack(s, length, wordDictSet, i, map);
                    nextWordBreaks.forEach(list -> {
                        LinkedList<String> wordBreak = new LinkedList<>(list);
                        wordBreak.offerFirst(word);
                        wordBreaks.add(wordBreak);
                    });
                }
            }
            map.put(index, wordBreaks);
        }
        return map.get(index);
    }

    public static void main(String[] args) {
        String str = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        System.out.println(wordBreak(str, wordDict));
    }
}
