package org.lyx.revoikeDemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TestHttpServer {
    public static void main(String[] args)  throws Exception{
        //1. 定义2个线程池 一个是boss 一个是worker, boss负责接收请求，然后传递给worker处理
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //2. 创建netty给我们提供的用来简化服务器端启动的ServerBootstrap 对象
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //3. 设置组、通道、事件流
            serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).childHandler(new TestHttpServerInitializer());
            //4. 绑定端口等数据
            ChannelFuture future = serverBootstrap.bind(8899).sync();
            future.channel().closeFuture().sync();
        }finally {
            // 5. 调用netty的优雅关闭
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
