package top.hengshare.interview.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {

	private final int port;

	public EchoServer(int port) {
		this.port = port;
	}

	public static void main(String[] args) throws InterruptedException {
		if (args.length != 1) {
			System.out.println("Usage: " + EchoServer.class.getSimpleName() + " <port>");//设置端口值，如果端口参数格式不正确，打印启动帮助信息
		}
		int port = Integer.parseInt(args[0]);
		new EchoServer(port).start();//调用服务器的start方法，开启服务器
	}

	private void start() throws InterruptedException {
		final EchoServerHandler echoServerHandler = new EchoServerHandler();//准备好服务器端的入站处理器
		EventLoopGroup group = new NioEventLoopGroup();//准备好处理消息需要使用的eventLoop组
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();//开始创建启动引导程序
			bootstrap.group(group)//设置eventLoop组
					.channel(NioServerSocketChannel.class)//设置nio通信管道
					.localAddress(new InetSocketAddress(port))//设置服务启动绑定地址
					.childHandler(new ChannelInitializer<SocketChannel>() {//将自定义的入栈处理器绑定到处理器列表的最后
						@Override
						protected void initChannel(SocketChannel ch) {
							ch.pipeline().addLast(echoServerHandler);
						}
					});
			ChannelFuture future = bootstrap.bind()//绑定之后
					.sync();//同步
			// 这个语句的主要目的是，如果缺失上述代码，则main方法所在的线程，即主线程会在执行完bind().sync()方法后，
			// 会进入finally 代码块，之前的启动的netty server也会随之关闭掉，整个程序都结束了。
			future.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully().sync();
		}
	}
}
