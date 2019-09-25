package top.hengshare.interview.pattern.simpleFactory.properties;

import top.hengshare.interview.pattern.simpleFactory.Animal;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertiesFactory {
    public static Animal seeAnimal(int code) {
        Properties properties = new Properties();
        InputStream in = null;
        try {
            properties.load(new FileReader("C:\\Users\\86379\\Desktop\\Java-Interview\\src\\main\\java\\top\\hengshare\\interview\\pattern\\simpleFactory\\properties\\FactoryTest.properties"));
        } catch (IOException e) {
            System.out.println("加载工厂配置文件出错，堆栈信息如下：");
            e.printStackTrace();
        }
        //读取完配置文件后，可以使用反射创建对象了
        Animal animal = null;
        try {
            if (code == 1) {
                animal = (Animal)Class.forName(properties.getProperty("Dog")).newInstance();
            }else {
                animal = (Animal)Class.forName(properties.getProperty("Cat")).newInstance();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return animal;
    }
}
