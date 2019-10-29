package top.hengshare.interview.pattern.interpreter.example2;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java-Interview
 * @description: 上下文
 * @author: StivenYang
 * @create: 2019-10-24 20:58
 **/
public class Context {

    /**
     * 上次被处理的多个元素
     */
    @Getter
    @Setter
    private List<Element> preEles = Lists.newArrayList();

    /**
     * Dom解析xml的Document对象
     */
    @Getter
    private Document document;

    /**
     * 构造方法，初始化dom对象
     * @param filePathName 文件路径名
     * @throws Exception 异常
     */
    public Context(String filePathName) throws Exception {
        this.document = XmlUtil.getRoot(filePathName);
    }

    /**
     * 重新初始化上下文
     */
    public void reInit(){
        preEles =null;
    }

    /**
     * 根据父元素和当前元素的名称，获取当前元素
     * @param pEle 父元素
     * @param eleName 当前元素名称
     * @return 当前元素
     */
    public List<Element> getNowEles(Element pEle, String eleName){
        ArrayList<Element> elements = Lists.newArrayList();
        //根据父节点及元素名，获取现有节点
        NodeList tempNodeList = pEle.getChildNodes();
        for (int i=0; i<tempNodeList.getLength(); i++){
            if (tempNodeList.item(i) instanceof Element){
                Element element = (Element) tempNodeList.item(i);
                if (element.getTagName().equals(eleName)) {
                    elements.add(element);
                }
            }
        }
        return elements;
    }


}
