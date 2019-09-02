package top.hengshare.interview.java8.ForkAndJoin;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MySpliterator {

    private static final String SENTENCE =
            " Nel mezzo del cammin di nostra vita " +
                    "mi ritrovai in una selva oscura" +
                    " ché la dritta via era smarrita ";

    /**
     * 普通风格的单词计数器实现
     *
     * @param s 字符串
     * @return 单词个数
     */
    public static int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {
                    counter++;
                }
                lastSpace = false;
            }
        }
        return counter;
    }

    /**
     * 使用函数式风格对字符串中单词个数进行统计
     *
     * @param stream
     * @return
     */
    private static int countWords(Stream<Character> stream) {
        WordCounter counter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);
        return counter.getCounter();
    }


    public static void main(String[] args) {
        //普通风格的字符串统计
        System.out.println(countWordsIteratively(SENTENCE));
        //串行函数式风格字符串统计
        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);
        System.out.println(countWords(stream));
        //错误的并行函数式风格字符串统计
        Stream<Character> stream2 = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);
        System.out.println(countWords(stream2.parallel()));
        //正确使用spliterator拆分数据源，制造并行流，完成字符串单词统计功能
        WordCounterSpliterator wordCounterSpliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream3 = StreamSupport.stream(wordCounterSpliterator, true);
        System.out.println(countWords(stream3));
    }
}

class WordCounter {
    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public WordCounter accumulate(Character c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ? this : new WordCounter(counter, true);
        } else {
            //上一个字符是空格，而当前遍历的字符不是空格时，将单词计数器加一
            return lastSpace ? new WordCounter(counter + 1, false) : this;
        }
    }

    public WordCounter combine(WordCounter wordCounter) {
        return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
    }

    public int getCounter() {
        return counter;
    }
}