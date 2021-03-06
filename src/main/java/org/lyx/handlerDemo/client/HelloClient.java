package org.lyx.handlerDemo.client;

import io.netty.bootstrap.Bootstrap;

import io.netty.channel.ChannelFuture;

import io.netty.channel.ChannelInitializer;

import io.netty.channel.ChannelOption;

import io.netty.channel.EventLoopGroup;

import io.netty.channel.nio.NioEventLoopGroup;

import io.netty.channel.socket.SocketChannel;

import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import org.lyx.handlerDemo.client.handler.InboundHandler3;
import org.lyx.handlerDemo.client.handler.InboundHandler4;
import org.lyx.handlerDemo.client.handler.OutboundHandler3;
import org.lyx.handlerDemo.client.handler.OutboundHandler4;

public class HelloClient {

	public void connect(String host, int port) throws Exception {
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(workerGroup);
			b.channel(NioSocketChannel.class);
			b.option(ChannelOption.SO_KEEPALIVE, true);
			b.handler(new ChannelInitializer<SocketChannel>() {
				@Override
				public void initChannel(SocketChannel ch) throws Exception {
					ch.pipeline().addLast(new ObjectEncoder());
					ch.pipeline().addLast(new OutboundHandler3());
					ch.pipeline().addLast(new OutboundHandler4());
					// 注册两个InboundHandler，执行顺序为注册顺序，所以应该是InboundHandler1 InboundHandler2
					ch.pipeline().addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.weakCachingConcurrentResolver(null))); // 最大长度
					ch.pipeline().addLast(new InboundHandler3());
					ch.pipeline().addLast(new InboundHandler4());

				}
			});
			// Start the client.
			ChannelFuture f = b.connect(host, port).sync();
			f.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
		}

	}

 

	public static void main(String[] args) throws Exception {
		HelloClient client = new HelloClient();
		client.connect("127.0.0.1", 8000);
	}

}
