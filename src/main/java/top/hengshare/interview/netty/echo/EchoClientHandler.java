package top.hengshare.interview.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;


@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) {//记录已接受消息的转储
		//todo 可以做一些消息的转储，消息被读取的时候调用
		System.out.println("Client received: " + msg.toString(CharsetUtil.UTF_8));
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) {//当被通知channel是活跃的时候，发送一条消息
		//新连接被建立的时候调用
		ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
