package top.hengshare.interview.pattern.decorator.java;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @program: Java-Interview
 * @description: IO
 * @author: StivenYang
 * @create: 2019-10-31 17:00
 **/
public class IO {
	public static void main(String[] args) throws IOException {
		//流式读取文件
		DataInputStream din = null;
		try {
			din = new DataInputStream(new BufferedInputStream(new FileInputStream("test.xml")));
			//然后就可以获取文件内容了
			byte[] bs = new byte[din.available()];
			din.read(bs);
			String content = new String(bs);
			System.out.println("文件内容=====" + content);
		} finally {
			din.close();
		}
	}
}
