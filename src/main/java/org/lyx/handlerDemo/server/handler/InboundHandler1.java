package org.lyx.handlerDemo.server.handler;

import io.netty.channel.ChannelHandlerContext;

import io.netty.channel.ChannelInboundHandlerAdapter;

 

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;


public class InboundHandler1 extends ChannelInboundHandlerAdapter {
	private static Logger	logger	= LoggerFactory.getLogger(InboundHandler1.class);

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("InboundHandler1.channelActive");
		int a=1;
		//ctx.fireChannelActive();
		ctx.writeAndFlush(a);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		logger.info("InboundHandler1.channelRead: ctx :" + ctx);
		if (msg instanceof  Integer){
			Integer  a=(Integer)msg;
			logger.info("a: {}",a);
			++a;
			//ctx.writeAndFlush(a);
			ctx.fireChannelRead(a);
		}
		// 通知执行下一个InboundHandler
		//ctx.fireChannelRead(msg);
	}

 

	@Override

	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.info("InboundHandler1.channelReadComplete");
		ctx.flush();

	}

}
