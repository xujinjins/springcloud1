package com.xjj.fileChannel;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 通过FIleChannel复制文件
 */
public class 直接缓冲区 {

    public static void main(String[] args) throws IOException {
       long begin = System.currentTimeMillis();
       FileChannel inChannel  = FileChannel.open(Paths.get("C:\\Users\\16394\\Desktop\\1.mp4"),StandardOpenOption.READ);
       FileChannel outChannel = FileChannel.open(Paths.get("C:\\Users\\16394\\Desktop\\2.mp4"),StandardOpenOption.READ,//
                                StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        MappedByteBuffer inMap  = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMap = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        byte[] bytes = new byte[inMap.limit()];
        inMap.get(bytes);
        outMap.put(bytes);
        outMap.clear();

        outChannel.close();
        inChannel.close();

        long end = System.currentTimeMillis();
        System.out.println("复制完毕,耗时："+(end-begin));
        //复制完毕,耗时：91

    }
}
