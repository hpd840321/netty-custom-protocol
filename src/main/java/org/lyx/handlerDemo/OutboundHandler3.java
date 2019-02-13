package org.lyx.handlerDemo;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OutboundHandler3 extends ChannelOutboundHandlerAdapter {

	private static Logger	logger	= LoggerFactory.getLogger(OutboundHandler3.class);

	@Override
	// 向client发送消息
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {

		logger.info("OutboundHandler3.write");
		String response = "I am ok!";
		ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
		encoded.writeBytes(response.getBytes());
		ctx.write(encoded);
		ctx.flush();

	}

	

	

}
