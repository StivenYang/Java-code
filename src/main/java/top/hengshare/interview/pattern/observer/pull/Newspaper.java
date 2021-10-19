package top.hengshare.interview.pattern.observer.pull;

public class Newspaper extends Subject {
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		this.notifyObservers();
	}
}
