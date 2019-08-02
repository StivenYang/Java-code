package top.hengshare.interviewer.java8.ForkAndJoin;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author Yang
 */
public class WordCounterSpliterator implements Spliterator<Character> {
    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    /**
     * 判断是否还有字符要处理，如果有，返回true，否则返回false
     *
     * @param action action，用来定义要执行的动作
     * @return 有：true；没有：false
     */
    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(string.charAt(currentChar++));
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if (currentSize < 10) {
            return null;
        }
        for (int spliPos = currentSize / 2 + currentChar; spliPos < string.length(); spliPos++) {
            if (Character.isWhitespace(string.charAt(spliPos))) {
                WordCounterSpliterator wordCounterSpliterator = new WordCounterSpliterator(string.substring(currentChar, spliPos));
                currentChar = spliPos;
                return wordCounterSpliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
