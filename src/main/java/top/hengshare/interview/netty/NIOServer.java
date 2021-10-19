package top.hengshare.interview.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NIOServer {
	private final int port;

	public NIOServer(int port) {
		this.port = port;
	}

	public void start() throws InterruptedException {
		//创建nio循环队列组
		NioEventLoopGroup group = new NioEventLoopGroup();
		try {
			//创建服务器快速启动实例
			ServerBootstrap b = new ServerBootstrap();
			//指定实例的端口地址和使用的循环队列
			//增加业务处理逻辑到channel
			b.group(group).channel(NioServerSocketChannel.class).localAddress(port)
					.childHandler(new ChannelInitializer<Channel>() {

						@Override
						protected void initChannel(Channel channel) throws Exception {
							channel.pipeline().addLast(new NIOServerHandler());
						}
					});
			//绑定服务器，等待服务器关闭，资源被释放
			ChannelFuture f = b.bind().sync();
			System.out.println(NIOServer.class.getName() + "已经启动，监听端口：" + f.channel().localAddress());
			f.channel().closeFuture().sync();

		} finally {
			group.shutdownGracefully().sync();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new NIOServer(65535).start();
	}
}

class NIOServerHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("服务器接收到消息：" + msg);
		ctx.write(msg);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}