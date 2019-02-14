package org.lyx.handlerDemo;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class InboundHandler4 extends ChannelInboundHandlerAdapter {

	private static Logger	logger	= LoggerFactory.getLogger(InboundHandler4.class);


	/*@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("InboundHandler2.channelActive: ctx :" + ctx);

	}*/

	@Override
	// 读取Client发送的信息，并打印出来
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		logger.info("InboundHandler4.channelRead: ctx :" + ctx);
		if (msg instanceof  Integer){
			Integer  a=(Integer)msg;
			logger.info("a: {}",a);
			++a;
			ctx.writeAndFlush(a);
			//ctx.fireChannelRead(a);
		}

	}

 

	@Override

	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.info("InboundHandler4.channelReadComplete");
		ctx.flush();
	}

 

}
