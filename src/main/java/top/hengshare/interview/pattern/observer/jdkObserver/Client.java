package top.hengshare.interview.pattern.observer.jdkObserver;

public class Client {
    public static void main(String[] args) {
        Newspaper newspaper = new Newspaper();

        Reader reader = new Reader();
        reader.setName("张三");
        newspaper.addObserver(reader);

        newspaper.setContent("报社推送的新消息");
    }
}
