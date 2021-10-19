package top.hengshare.interview.netty.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.ImmediateEventExecutor;

import java.net.InetSocketAddress;

public class ChatServer {

	private final ChannelGroup channelGroup = new DefaultChannelGroup(ImmediateEventExecutor.INSTANCE);
	private final EventLoopGroup group = new NioEventLoopGroup();
	private Channel channel;

	public static void main(String[] args) throws Exception {
		if (args.length != 1) {
			System.err.println("please give a port!");
			System.exit(1);
		}
		int port = Integer.parseInt(args[0]);

		final ChatServer endPoint = new ChatServer();
		ChannelFuture start = endPoint.start(new InetSocketAddress(port));
		Runtime.getRuntime().addShutdownHook(new Thread(endPoint::destroy));
		start.channel().closeFuture().syncUninterruptibly();
	}

	public void destroy() {
		if (channel != null) {
			channel.close();
		}
		channelGroup.close();
		group.shutdownGracefully();
	}

	public ChannelFuture start(InetSocketAddress address) {
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		serverBootstrap.group(group).channel(NioServerSocketChannel.class)
				.childHandler(createInitializer(channelGroup));
		ChannelFuture future = serverBootstrap.bind(address);
		future.syncUninterruptibly();
		channel = future.channel();
		return future;
	}

	public ChannelHandler createInitializer(ChannelGroup channelGroup) {
		return new ChatServerInitializer(channelGroup);
	}
}
