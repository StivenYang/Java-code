package top.hengshare.interview.netty.oio;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 解释一下oio同步阻塞编程的代码
 *
 * @author yangjh
 */
public class PlainOioServer {
	public void server(int port) throws IOException {
		final ServerSocket socket = new ServerSocket(port);
		try {
			do {
				final Socket clientSocket = socket.accept();
				System.out.println("接受来自于" + clientSocket + "的连接");
				new Thread(() -> {
					OutputStream out;
					try {
						out = clientSocket.getOutputStream();
						out.write("Hi! \r\n".getBytes(StandardCharsets.UTF_8));
						out.flush();
						clientSocket.close();
					} catch (IOException e) {
						System.out.println(ExceptionUtils.getStackTrace(e));
					} finally {
						try {
							clientSocket.close();
						} catch (IOException e) {
							//ignore on close
						}
					}
				}).start();
			} while (true);
		} catch (Exception e) {
			System.out.println(ExceptionUtils.getStackTrace(e));
		}
	}

	public static void main(String[] args) throws IOException {
		new PlainOioServer().server(8082);
	}
}
