package com.xjj.nio;

import java.nio.ByteBuffer;

/**
 * nio简单测试
 */
public class NioDemo1 {
    public static void main(String[] args) {
        //初始化缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        /**
             初始化后的信息
             position:0
             limit:1024
             capacity:1024
         */
        System.out.println("初始化后的信息");
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());
        /**
         * 放入值过后的信息
            position:8
            limit:1024
            capacity:1024
         *
         */
        buf.put("xujinjin".getBytes());
        System.out.println("放入值过后的信息");
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());
        /**
            开启读过后的信息
            position:0
            limit:8
            capacity:1024
         */
        buf.flip();
        System.out.println("开启读过后的信息");
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());
        /**
            读取通道中的信息
            获取到的值：xujinjin
            获取值之后的信息
            position:8
            limit:8
            capacity:1024
         */
        System.out.println("读取通道中的信息");
        byte[] bytes = new byte[buf.limit()];
        buf.get(bytes);
        System.out.println("获取到的值："+new String(bytes,0,bytes.length));
        System.out.println("获取值之后的信息");
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());
        /**
            开启重复读之后：
            position:0
            limit:8
            capacity:1024
         */
        System.out.println("开启重复读之后：");
        buf.rewind();
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());
        /**
            清空缓冲区：
            position:0
            limit:1024
            capacity:1024
            值:x
         */
        System.out.println("清空缓冲区：");
        buf.clear();
        System.out.println("position:"+buf.position());
        System.out.println("limit:"+buf.limit());
        System.out.println("capacity:"+buf.capacity());
        System.out.println("值:"+(char)buf.get());
    }
}
