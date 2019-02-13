package org.lyx.demo.custom.server;

import org.lyx.demo.custom.struct.NettyMessage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter {

	/**
	 * 当我们通道进行激活的时候 触发的监听方法
	 */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    	System.err.println("--------通道激活------------");
        super.channelActive(ctx);
    }

    /**
     * 当我们的通道里有数据进行读取的时候 触发的监听方法
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx /*NETTY服务上下文*/, Object msg /*实际的传输数据*/) throws Exception {
    	
    	NettyMessage requestMessage = (NettyMessage)msg;
    	System.err.println("服务端 channelRead Server receive message from Client: " + requestMessage.getBody());
    	NettyMessage responseMessage = new NettyMessage();
		ctx.writeAndFlush(responseMessage);
    	
    }
    

    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
    	System.err.println("--------服务器数据读异常----------: ");
    	cause.printStackTrace();
        ctx.close();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
