package com.miracle.framework.remote.netty.client;


import com.miracle.framework.remote.client.exception.ClientException;
import com.miracle.framework.remote.exchange.Response;
import com.miracle.framework.remote.netty.Student;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.commons.io.IOUtils;


import java.io.FileInputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class NettyClientDispatchHandler extends ChannelInboundHandlerAdapter {
	
	private final ConcurrentHashMap<Long, BlockingQueue> responseMap = new ConcurrentHashMap<Long, BlockingQueue> ();


	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush("客户端连接成功");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		byte[]	 picture= IOUtils.toByteArray( new FileInputStream("E:\\小智考勤.jpg"));
		Student student=new Student();
		student.setName("测试");
		student.setPicture(picture);
		super.channelRead(ctx, msg);
	}
}
