package top.hengshare.interview.thread.concurrency;


import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author StivenYang
 * @program interview
 * @description 使用管道在线程间进行通信
 * @date 2019-07-10 13:38
 **/
class Sender implements Runnable {
    //生成一个随机数种子，隔随机时间向管道中输入数据
    private Random random = new Random(47);
    //新建一个管道写对象
    private PipedWriter writer = new PipedWriter();

    //获取管道属性
    public PipedWriter getWriter() {
        return writer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                //向管道写入字符串
                for (char c = 'A'; c < 'z'; c++) {
                    writer.write(c);
                }
                //sleep一段时间
                TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
            }
        } catch (IOException e) {
            System.out.println("io异常");
        } catch (InterruptedException e) {
            System.out.println("中断异常");
        }
    }
}

class Receiver implements Runnable {
    //新建一管道读对象，从管道读取字符串
    private PipedReader reader;

    //构造方法，参数为写入管道，用来绑定对应的写入管道
    public Receiver(Sender sender) throws IOException {
        this.reader = new PipedReader(sender.getWriter());
    }

    @Override
    public void run() {
        //从读管道中读取字符串
        try {
            while (true) {
                System.out.print((char) reader.read() + ",");
            }
        } catch (IOException e) {
            System.out.println("reader io异常");
        }
    }
}

public class PipedIO {
    public static void main(String[] args) throws IOException, InterruptedException {
        //新建一个发送者
        Sender sender = new Sender();
        //新建一个读取者
        Receiver receiver = new Receiver(sender);
        //启动发送者任务
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        //启动接受者任务
        exec.execute(receiver);
        //sleep
        TimeUnit.SECONDS.sleep(4);
        //shutdownnow
        exec.shutdownNow();
    }
}
