package top.hengshare.interview.netty.nettyoio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * 用netty实现的oio
 *
 * @author yangjh
 */
public class NettyOioServer {
	public void server(int port) throws InterruptedException {
		//构造要发送的字符串
		ByteBuf byteBuf = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Hi\r\n".getBytes()));
		//创建一个oio的eventLoopGroup
		EventLoopGroup group = new OioEventLoopGroup();
		//创建一个服务器引导
		try {
			//配置引导
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(group).channel(OioServerSocketChannel.class).localAddress(new InetSocketAddress(port))
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
								@Override
								public void channelActive(ChannelHandlerContext ctx) throws Exception {
									ctx.writeAndFlush(byteBuf.duplicate()).addListener(ChannelFutureListener.CLOSE);
								}
							});
						}
					});
			//绑定服务器端口并启动
			ChannelFuture f = bootstrap.bind().sync();
			f.channel().closeFuture().sync();
		} finally {
			//优雅释放服务器资源
			group.shutdownGracefully().sync();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new NettyOioServer().server(8083);
	}
}
