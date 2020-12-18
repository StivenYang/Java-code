package top.hengshare.interview.java8.lambda;


import java.util.function.Function;

/**
 * @author dxm
 */
public class FunctionComplex {
    public static void main(String[] args) {
        String text = "我是一个普通的程序员，我喜欢敲代码，它可以让我实现自己的价值，帮助这个社会变得更美好。\n我最近在学习labda表达式，他真是太方便，太强大了！";

        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> resultFunction = addHeader.andThen(Letter::addFooter)
                .andThen(Letter::checkSpelling);
        String result = resultFunction.apply(text);
        System.out.println(result);
    }
}

class Letter {
    public static String addHeader(String text) {
        return "亲爱的xxx: \n    " + text;
    }

    public static String addFooter(String text) {
        return text + " \n    此致！敬礼！";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
