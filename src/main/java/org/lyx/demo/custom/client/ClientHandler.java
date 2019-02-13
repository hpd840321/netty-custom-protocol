package org.lyx.demo.custom.client;

import org.lyx.demo.MessageType;
import org.lyx.demo.custom.struct.Header;
import org.lyx.demo.custom.struct.NettyMessage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public class ClientHandler  extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
     //   super.channelActive(ctx);
        NettyMessage message = new NettyMessage();
        Header header=new Header();
        header.setType(MessageType.HEARTBEAT_REQ.value());
        header.setLength(1024*1024*1024*2);
        message.setHeader(header);
        message.setBody("客户端  channelActive: request message");
        ctx.writeAndFlush(message);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    	try {
          System.out.println("客户端接收数据");
    	 	NettyMessage message = new NettyMessage();
            Header header = new Header();
            header.setSessionID(2002L);
            header.setPriority((byte)2);
            header.setType((byte)1);
            message.setHeader(header);
          //  message.setBody("我是响应数据: " + new ImageBuilder().getImgBody());
            message.setBody("我是响应数据: 简化版" );
        	System.err.println("客户端：  Client receive message from server: " );
        	ctx.writeAndFlush(message);

    		
		} finally {
			ReferenceCountUtil.release(msg);
		}
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {

    	System.err.println("----------客户端数据读异常-----------"+cause.getMessage());
        ctx.close();
    }
    
}
