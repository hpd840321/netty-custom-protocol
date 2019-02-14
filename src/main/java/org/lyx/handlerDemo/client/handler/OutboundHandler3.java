package org.lyx.handlerDemo.client.handler;


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
		if (msg instanceof  Integer){
			Integer  a=(Integer)msg;
			logger.info("a: {}",a);
			++a;
			ctx.writeAndFlush(a);
		}

	}

	

	

}
