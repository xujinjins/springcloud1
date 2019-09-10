package com.xjj.fileChannel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通过buffer数组进行拆分，然后再通过此数组进行组合写入。
 */
public class 文件分散读取和聚集写入 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("C:\\Users\\16394\\Desktop\\1.txt", "rw");
        FileChannel channel = raf.getChannel();

        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        ByteBuffer[] bufs = {buf1,buf2};
        channel.read(bufs);

        for(int i=0;i<bufs.length;i++){
            ByteBuffer byteBuffer = bufs[i];
            byteBuffer.flip();
        }

        System.out.println("buf1:"+new String(bufs[0].array(),0,bufs[0].limit()));
        System.out.println("===========================================================");
        System.out.println("buf2:"+new String(bufs[1].array(),0,bufs[1].limit()));

        RandomAccessFile raf2 = new RandomAccessFile("C:\\Users\\16394\\Desktop\\2.txt","rw");
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufs);

        channel.close();
        channel2.close();
    }
}
