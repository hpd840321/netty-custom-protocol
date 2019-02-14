package org.lyx.revoikeDemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

public class TestHttpHandler extends SimpleChannelInboundHandler<HttpObject> {

    /**
     * 该方法在5.0中被命名为messageReceived，估计后期还是会对该方法进行重命名
     * 该方法的主要作用是读取客户端的请求，并生产相应数据,我们在该处返回一个helloworld
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
            if (msg instanceof HttpRequest) //过滤非HTTP的请求和垃圾请求
            {
                HttpRequest req = (HttpRequest)msg; //将对象强制类型转换为HttpRequest的对象
                URI uri = new URI(req.uri()); //注意不要引错了包，是java.net下的
                if ("/favicon.ico".equals(uri.getPath())) //过滤掉图标请求
                {
                    System.out.println("get favicon.icon");
                    return;
                }
                System.out.println("invoked....");
                //1.定义返回对象
                ByteBuf content = Unpooled.copiedBuffer("hello world", CharsetUtil.UTF_8);
                //2. 定义response返回对象，注意该处的response对象不是servlet中的HttpResponse,他是netty自己封装的返回数据，跟http没有任何关系
                FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK, content);
                //3. 设置返回的数据头信息
                response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
                response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
                //4. 调用ctx返回response对象
                ctx.writeAndFlush(response);
            }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel added");
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel registered");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel active");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel ininactive");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channel unregistered");
    }
}