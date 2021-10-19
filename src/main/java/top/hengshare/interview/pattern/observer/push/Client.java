package top.hengshare.interview.pattern.observer.push;

/**
 * 拉模型的实例
 */
public class Client {
	public static void main(String[] args) {
		Newspaper newspaper = new Newspaper();

		Reader reader = new Reader();
		reader.setName("张三");

		Reader reader1 = new Reader();
		reader1.setName("李四");

		Reader reader2 = new Reader();
		reader2.setName("王五");

		newspaper.attach(reader);
		newspaper.attach(reader2);
		newspaper.attach(reader1);

		newspaper.setContent("报纸内容变了");
	}
}
