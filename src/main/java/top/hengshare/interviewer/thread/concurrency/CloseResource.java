package top.hengshare.interviewer.thread.concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author StivenYang
 * @program interview
 * @description 关闭任务在其上发生阻塞的底层资源
 * @date 2019-06-30 17:51
 **/
public class CloseResource {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InputStream socketInput = new Socket("localhost", 8080).getInputStream();
        exec.execute(new IOBlocked(socketInput));
        exec.execute(new IOBlocked(System.in));
        TimeUnit.SECONDS.sleep(1);
        System.out.println("正在关闭所有的线程。。。");
        exec.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("正在关闭：" + socketInput.getClass().getName());
        socketInput.close();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("正在关闭：" + System.in.getClass().getName());
        System.in.close();
    }
}
