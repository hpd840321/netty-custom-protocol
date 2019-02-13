package org.lyx.codeHandlerDemo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ClientInitHandler extends ChannelInboundHandlerAdapter {
	private Logger logger	= LoggerFactory.getLogger(ClientInitHandler.class);
	private ByteBufToBytes	reader;


	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.error("channelActive {}",logger.getName());
		ctx.writeAndFlush("I am OK!");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof HttpResponse) {
			HttpResponse response = (HttpResponse) msg;
			if (HttpHeaders.isContentLengthSet(response)) {
				reader = new ByteBufToBytes((int) HttpHeaders.getContentLength(response));
			}
		}

		if (msg instanceof HttpContent) {
			HttpContent httpContent = (HttpContent) msg;
			ByteBuf content = httpContent.content();
			reader.reading(content);
			content.release();
			if (reader.isEnd()) {
				String resultStr = new String(reader.readFull());
				System.out.println("Server said:" + resultStr);
			}
		}else{
			ctx.writeAndFlush("i am ok !");
		}


	}

 

	@Override

	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.close();
	}

 

}
