package com.xjj.fileChannel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class 非直接缓冲区 {
    public static void main(String[] args) throws IOException {
        long begin = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("C:\\Users\\16394\\Desktop\\1.mp4");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\16394\\Desktop\\2.mp4");

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024);
        while (inChannel.read(buf)!=-1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }
        outChannel.close();
        inChannel.close();
        fos.close();
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println("复制完毕,耗时："+(end-begin));

        //复制完毕,耗时：1096
    }
}
