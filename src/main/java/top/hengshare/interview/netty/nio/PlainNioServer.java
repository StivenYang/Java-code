package top.hengshare.interview.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 使用异步io的异步网络编程
 *
 * @author yangjh
 */
public class PlainNioServer {

	public void server(int port) throws IOException {
		//创建一个channel
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		//设置channel非阻塞
		serverSocketChannel.configureBlocking(false);
		ServerSocket sSocket = serverSocketChannel.socket();
		//创建一个网络套接字，并绑定端口
		InetSocketAddress address = new InetSocketAddress(port);
		sSocket.bind(address);
		//开启selctor
		Selector selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		final ByteBuffer msg = ByteBuffer.wrap("Hi! \r\n".getBytes());
		for (; ; ) {
			try {
				selector.select();
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
			Set<SelectionKey> readyKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = readyKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey next = iterator.next();
				iterator.remove();
				try {
					if (next.isAcceptable()) {
						ServerSocketChannel server = (ServerSocketChannel) next.channel();
						SocketChannel client = server.accept();
						client.configureBlocking(false);
						client.register(selector, SelectionKey.OP_WRITE | SelectionKey.OP_READ, msg.duplicate());
						System.out.println("Accept Connect from : " + client);
					}
					if (next.isWritable()) {
						SocketChannel client = (SocketChannel) next.channel();
						ByteBuffer buffer = (ByteBuffer) next.attachment();
						while (buffer.hasRemaining()) {
							if (client.write(buffer) == 0) {
								break;
							}
						}
						client.close();
					}
				} catch (IOException e) {
					next.cancel();
					try {
						next.channel().close();
					} catch (IOException cex) {
						//ignore
					}
				}
			}
		}
	}
}
