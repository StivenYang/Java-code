package top.hengshare.interview.jvm.jconsole;

import java.util.ArrayList;

/**
 * 内存占位符对象，一个对象OOM对象大约占64KB
 * @author yang
 */
public class OOMObject {
    public byte[] placeholder = new byte[64*1024];

    public static void fillHeap(int num) throws InterruptedException {
        ArrayList<OOMObject> list = new ArrayList<>();
        for (int i = 0; i<num; i++){
            //稍作延时，令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
