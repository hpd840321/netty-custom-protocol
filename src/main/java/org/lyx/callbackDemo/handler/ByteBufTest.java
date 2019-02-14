package org.lyx.callbackDemo.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;

public class ByteBufTest {
    public static void main(String[] args) {
        ByteBufAllocator  alloc = PooledByteBufAllocator.DEFAULT;
        ByteBuf byteBuf = alloc.directBuffer(8*1024);


        //很重要，内存释放
        byteBuf.release();
    }
}