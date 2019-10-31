package top.hengshare.interview.pattern.decorator.java;

import java.io.*;

/**
 * @program: Java-Interview
 * @description: EncryOutputStream2
 * @author: StivenYang
 * @create: 2019-10-31 18:24
 **/
public class EncryOutputStream2 extends FilterOutputStream {
    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field <tt>this.out</tt> for later use, or
     *            <code>null</code> if this instance is to be
     *            created without an underlying stream.
     */
    public EncryOutputStream2(OutputStream out) {
        super(out);
    }

    @Override
    public void write(int b) throws IOException {
        b = b+2;
        if (b >= (97 + 26)) {
            b = b - 26;
        }
        super.write(b);
    }

    public static void main(String[] args) throws Exception {
        //流式输出文件
        DataOutputStream dout = new DataOutputStream(
                new BufferedOutputStream(
                        new EncryOutputStream2(
                                new FileOutputStream("test1.xml")
                        )
                )
        );
        //然后就可以输出内容了
        dout.write("abcdxyz".getBytes());
        dout.close();
    }
}
