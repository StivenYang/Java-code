package top.hengshare.interviewer.regix;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Yang Jiaheng
 * @date: 2019/3/27
 * @description: 使用正则表达式提取"abcdef"
 */
public class PatternCredit {
    public static void main(String[] args) throws IOException {
        StringBuilder builder = new StringBuilder();
        //初始化字符串
        List<String> strList = Files.readLines(new File("d:/123.txt"), Charset.forName("utf-8"));
        int size = strList.size();

        //定义匹配模式
        Pattern pattern = Pattern.compile("public (String|Date) ([0-9a-zA-Z]+)");

        //两个指针，一个是上一行，一个是本行
        int j = 0;
        for (int i = 1; i < size; i++) {
            Matcher matcher = pattern.matcher(strList.get(i));
            if (matcher.find()) {
                builder.append(strList.get(j) + "\r\n@Field(\"" + matcher.group(2) + "\");\r\n" + strList.get(i));
            } else {
                builder.append("\r\n");
            }
        }

        Files.write(builder.toString().getBytes(), new File("d:/234.txt"));
        System.out.println(builder.toString());

    }
}
