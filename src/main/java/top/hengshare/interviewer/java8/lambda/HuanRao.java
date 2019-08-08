package top.hengshare.interviewer.java8.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HuanRao {

    /**
     * 记得行为参数化
     *
     * @return
     * @throws IOException
     */
    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    /**
     * 执行一个行为
     *
     * @param bufferedReaderProcessor
     * @return
     * @throws IOException
     */
    public static String processFile(BufferedReaderProcessor bufferedReaderProcessor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return bufferedReaderProcessor.process(br);
        }
    }

    public static void main(String[] args) throws IOException {
        String result = HuanRao.processFile();
    }
}

/**
 * 使用函数式接口传递行为
 * 接口只包含一个抽象方法，此实例的函数描述符为 (BufferedReader) -> String
 * 反应到函数定义就是：返回值为String，函数的参数为BuffereReader类型
 */
@FunctionalInterface
interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;

    public static void main(String[] args) throws IOException {
        //传递lambda表达式
        HuanRao.processFile(BufferedReader::readLine);
        HuanRao.processFile((BufferedReader br) -> br.readLine() + br.readLine());
    }
}
