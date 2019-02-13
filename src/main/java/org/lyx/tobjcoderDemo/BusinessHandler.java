package org.lyx.tobjcoderDemo;

 

import io.netty.channel.ChannelHandlerContext;

import io.netty.channel.ChannelInboundHandlerAdapter;

 

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

 

public class BusinessHandler extends ChannelInboundHandlerAdapter {
	private Logger	logger	= LoggerFactory.getLogger(BusinessHandler.class);


	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("BusinessHandler  channelActive" );
		Person person = new Person();
		ctx.writeAndFlush(person);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		Person person = new Person();
		logger.info("BusinessHandler read msg from client :" + person);
         ctx.writeAndFlush(person);
	}

 

	@Override

	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	

	@Override

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

		

	}

}
