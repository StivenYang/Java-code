package top.hengshare.interview.pattern.decorator.java;

import java.io.*;

/**
 * @program: Java-Interview
 * @description: EncryOutputStream
 * @author: StivenYang
 * @create: 2019-10-31 17:09
 **/
public class EncryOutputStream extends OutputStream {

    /**
     * 持有被装饰的对象
     */
    private OutputStream os = null;

    public EncryOutputStream(OutputStream os) {
        this.os = os;
    }

    @Override
    public void write(int b) throws IOException {
        //统一向后移动两位
        b = b + 2;
        //判断是否是小谢字母
        if (b >= (97 + 26)) {
            //如果大于"z"的码值，减去26就回到a了
            b = b - 26;
        }
        this.os.write(b);
    }

    public static void main(String[] args) throws Exception {
        //流式输出文件
        DataOutputStream dout = new DataOutputStream(
                new BufferedOutputStream(
                        new EncryOutputStream(
                                new FileOutputStream("test1.xml")
                        )
                )
        );
        //然后就可以输出内容了
        dout.write("abcdxyz".getBytes());
        dout.close();
    }
}
