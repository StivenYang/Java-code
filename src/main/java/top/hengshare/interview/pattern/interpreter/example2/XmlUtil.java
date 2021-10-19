package top.hengshare.interview.pattern.interpreter.example2;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @program: Java-Interview
 * @description: XmlUtil
 * @author: StivenYang
 * @create: 2019-10-24 21:14
 **/
public class XmlUtil {
	public static Document getRoot(String filePathName) throws ParserConfigurationException, IOException, SAXException {
		Document doc;
		//建立一个解析器工厂
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
		//获得一个DocumentBuilder对象，这个对象代表了具体的Dom解析器
		DocumentBuilder builder = fac.newDocumentBuilder();
		//得到一个表示xml文档的Document对象
		doc = builder.parse(filePathName);
		//去掉xml文档中作为格式化内容的空白而映射在Dom树中的TextNode对象
		doc.normalize();

		return doc;
	}
}
