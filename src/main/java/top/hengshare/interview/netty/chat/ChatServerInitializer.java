package top.hengshare.interview.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class ChatServerInitializer extends ChannelInitializer<Channel> {

	private final ChannelGroup group;

	public ChatServerInitializer(ChannelGroup group) {
		this.group = group;
	}

	@Override
	protected void initChannel(Channel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		//可以将字节解码为HTTP request也可以编码为字节
		pipeline.addLast(new HttpServerCodec());
		//写入一个文件的内容
		pipeline.addLast(new ChunkedWriteHandler());
		//聚合http消息，安装完之后，pipeLine中的下一个channelHandler将只会收到完整的http请求或响应
		pipeline.addLast(new HttpObjectAggregator(64 * 1024));
		//处理http请求
		pipeline.addLast(new HttpRequestHandler("/ws"));
		//处理websocketFrame，包含：升级frame，pingFrame，pongFrame，closeFrame
		pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
		//处理textWebSocketFrame
		pipeline.addLast(new TextWebSocketFrameHandler(group));
	}
}
