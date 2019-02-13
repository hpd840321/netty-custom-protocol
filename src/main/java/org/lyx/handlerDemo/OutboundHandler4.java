package org.lyx.handlerDemo;

 

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OutboundHandler4 extends ChannelOutboundHandlerAdapter {
	private static Logger	logger	= LoggerFactory.getLogger(OutboundHandler4.class);
	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		logger.info("OutboundHandler4.write");
		// 执行下一个OutboundHandler
		super.write(ctx, msg, promise);

	}

}
