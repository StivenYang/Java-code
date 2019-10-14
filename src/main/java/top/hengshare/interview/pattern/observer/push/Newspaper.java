package top.hengshare.interview.pattern.observer.push;

public class Newspaper extends Subject {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        //推模式这里传递的是具体内容
        this.notifyObservers(content);
    }
}
