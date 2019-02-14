package org.lyx.revoikeDemo;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestHttpServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //HttpServerCodec是netty中非常重要的一个类,用来设置http的编码和解码，
        pipeline.addLast("httpServerCodec", new HttpServerCodec());
        //添加自己的处理器
        pipeline.addLast(new TestHttpHandler());
    }
}
