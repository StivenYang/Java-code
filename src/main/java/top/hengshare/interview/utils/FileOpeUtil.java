package top.hengshare.interview.utils;

import com.google.common.collect.Queues;

import java.io.*;
import java.util.Queue;

public class FileOpeUtil {

    private FileOpeUtil() {
    }

    public static Queue readFile(String filePath) {
        Queue list = Queues.newArrayDeque();
        ObjectInputStream oin = null;

        try {
            File file = new File(filePath);
            if (file.exists()) {
                oin  = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
                list = (Queue) oin.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oin != null) {
                    oin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void writeFile(String fileName, Queue list) {
        File file = new File(fileName);
        ObjectOutputStream oout = null;
        try {
            oout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            oout.writeObject(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                oout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
