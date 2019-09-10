package com.xjj.nio;

import java.nio.ByteBuffer;

/**
 * nio简单测试2
 */
public class NioDemo2 {
    public static void main(String[] args) {
        //初始化缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put("xujinjin".getBytes());
        /**
         * 开启读的模式
         * 获取到的值：xu
         * position:2
         * limit:8
         * capacity:1024
         */
        buf.flip();
        byte[] bytes = new byte[buf.limit()];
        buf.get(bytes,0,2);
        System.out.println("开启读的模式");
        System.out.println("获取到的值："+new String(bytes,0,bytes.length));
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());
        /**
             获取到的值：xuji
             position:4
             limit:8
             capacity:1024
         */
        buf.mark();//加不加mark效果都一样,但是加了mark可以reset，不加会抛异常。
        buf.get(bytes,2,2);
        System.out.println("获取到的值："+new String(bytes,0,bytes.length));
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());
        /**
         * position:2
         * limit:8
         * capacity:1024
         */
        buf.reset();
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());
    }
}
