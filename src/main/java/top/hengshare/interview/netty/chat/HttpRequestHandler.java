package top.hengshare.interview.netty.chat;

import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.stream.ChunkedNioFile;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * 扩展SimpleChannelInboundHandler用来处理所有的 http请求
 *
 * @author yangjh
 */
public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

	private final String wsUri;
	private static final File INDEX;

	//初始化一个字符串，表示ws升级协议
	static {
		URL location = HttpRequestHandler.class.getProtectionDomain().getCodeSource().getLocation();
		try {
			String path = location.toURI() + "index.html";
			path = !path.contains("file:") ? path : path.substring(5);
			INDEX = new File(path);
		} catch (URISyntaxException e) {
			throw new IllegalStateException("unable to locate index.html", e);
		}
	}

	public HttpRequestHandler(String wsUri) {
		this.wsUri = wsUri;
	}

	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest)
			throws Exception {
		if (wsUri.equalsIgnoreCase(fullHttpRequest.uri())) {
			//如果请求的是协议升级url，那么增加引用计数，并将它传给下一个ChannelInboundHandler
			channelHandlerContext.fireChannelRead(fullHttpRequest.retain());
		} else {
			//处理100 Continue请求以符合Http 1.1规范
			if (HttpUtil.is100ContinueExpected(fullHttpRequest)) {
				send100Continue(channelHandlerContext);
			}
			//读取index.html
			RandomAccessFile file = new RandomAccessFile(INDEX, "w+");
			DefaultHttpResponse response = new DefaultHttpResponse(fullHttpRequest.protocolVersion(),
					HttpResponseStatus.OK);
			response.headers().set(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.TEXT_PLAIN);
			boolean keepAlive = HttpUtil.isKeepAlive(fullHttpRequest);
			if (keepAlive) {
				response.headers().set(HttpHeaderNames.CONTENT_LENGTH, file.length())
						.set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
			}
			//将http response写到客户端
			channelHandlerContext.write(response);
			//将index.html写到客户端
			if (channelHandlerContext.pipeline().get(SslHandler.class) == null) {
				channelHandlerContext.write(new DefaultFileRegion(file.getChannel(), 0, file.length()));
			} else {
				channelHandlerContext.write(new ChunkedNioFile(file.getChannel()));
			}

			//写lastHttpContent并冲刷至客户端
			ChannelFuture future = channelHandlerContext.writeAndFlush(LastHttpContent.EMPTY_LAST_CONTENT);

			//如果没有请求keep-alive，则在写操作完毕后关闭channel
			if (!keepAlive) {
				future.addListener(ChannelFutureListener.CLOSE);
			}
		}
	}

	private void send100Continue(ChannelHandlerContext channelHandlerContext) {
		FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE);
		channelHandlerContext.writeAndFlush(response);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
}
