package top.hengshare.interview.netty.nettynio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class NettyNioServer {
	public void server(int port) throws InterruptedException {
		final ByteBuf buf = Unpooled.copiedBuffer("hi! \r\n", StandardCharsets.UTF_8);
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(group).localAddress(new InetSocketAddress(port)).channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
								@Override
								public void channelActive(ChannelHandlerContext ctx) throws Exception {
									ctx.writeAndFlush(buf.duplicate()).addListener(ChannelFutureListener.CLOSE);
								}
							});
						}
					});
			ChannelFuture future = b.bind().sync();
			future.channel().closeFuture().sync();
		} finally {
			group.shutdownGracefully().sync();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new NettyNioServer().server(8083);
	}
}
