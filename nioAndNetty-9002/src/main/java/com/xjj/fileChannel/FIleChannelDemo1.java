package com.xjj.fileChannel;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 通过FIleChannel复制文件
 */
public class FIleChannelDemo1 {

    public static void main(String[] args) throws IOException {

       FileChannel inChannel  = FileChannel.open(Paths.get("C:\\Users\\16394\\Desktop\\1.png"),StandardOpenOption.READ);
       FileChannel outChannel = FileChannel.open(Paths.get("C:\\Users\\16394\\Desktop\\2.png"),StandardOpenOption.READ,//
                                StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        MappedByteBuffer inMap  = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMap = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());

        byte[] bytes = new byte[inMap.limit()];
        inMap.get(bytes);
        outMap.put(bytes);
        outMap.clear();


    }
}
