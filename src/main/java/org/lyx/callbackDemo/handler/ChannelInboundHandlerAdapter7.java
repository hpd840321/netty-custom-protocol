package org.lyx.callbackDemo.handler;

import io.netty.channel.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChannelInboundHandlerAdapter7 extends ChannelInboundHandlerAdapter {
     ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("ChannelInboundHandlerAdapter6");
        fixedThreadPool.execute(new ThreadTep(ctx.channel()));
    }

    class ThreadTep implements Runnable {
        private Channel channel;
        public ThreadTep() {
        }

        public ThreadTep(Channel channel) {
            this.channel = channel;
        }

        public void run() {
            ChannelFuture future = channel.writeAndFlush("hello5");
            future.addListener(new ChannelFutureListener() {
                public void operationComplete(ChannelFuture future) throws Exception {
                    System.out.println("======isDone");
                    if (future.isSuccess()) {
                        Thread.sleep(5000);
                        System.out.println("======isSuccess");
                    }
                }
            });
            System.out.println("continue,not stop");
        }
    }
}