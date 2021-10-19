package top.hengshare.interview.netty.echo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class EchoClient {
	private final String host;
	private final int port;

	public EchoClient(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public void start() throws InterruptedException {
		EventLoopGroup group = new NioEventLoopGroup();//每个客户端启动都需要先创建一个eventLoop组
		try {
			Bootstrap bootstrap = new Bootstrap();//创建客户端的启动器
			bootstrap.group(group).channel(NioSocketChannel.class)//设置channel类型
					.remoteAddress(new InetSocketAddress(host, port))
					.handler(new ChannelInitializer<SocketChannel>() {//设置channel初始化方法
						@Override
						protected void initChannel(SocketChannel ch) {
							ch.pipeline().addLast(new EchoClientHandler());
						}
					});
			ChannelFuture future = bootstrap.connect().sync();//连接同步
			future.channel().closeFuture().sync();//为防止程序关闭资源直接被释放，这里加个关闭同步
		} finally {
			group.shutdownGracefully().sync();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 2) {
			System.out.println("Usage: " + EchoClient.class.getSimpleName() + " <host> <port>");
		}
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		new EchoClient(host, port).start();
	}
}
