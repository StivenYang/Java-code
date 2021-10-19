package top.hengshare.interview.netty.chat;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;

import java.net.InetSocketAddress;

public class SecureChatServer extends ChatServer {

    private final SslContext sslContext;

    public SecureChatServer(SslContext sslContext) {
        this.sslContext = sslContext;
    }

    @Override
    public ChannelHandler createInitializer(ChannelGroup channelGroup) {
        return new SecureChatServerInitializer(channelGroup, sslContext);
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("please give port as argument.");
            System.exit(1);
        }
        int port = Integer.parseInt(args[0]);
        SelfSignedCertificate certificate = new SelfSignedCertificate();
        SslContext sslContext = SslContextBuilder.forServer(certificate.certificate(), certificate.privateKey()).build();

        SecureChatServer secureChatServer = new SecureChatServer(sslContext);
        ChannelFuture future = secureChatServer.start(new InetSocketAddress(port));
        Runtime.getRuntime().addShutdownHook(new Thread(secureChatServer::destroy));

        future.channel().closeFuture().syncUninterruptibly();
    }
}
