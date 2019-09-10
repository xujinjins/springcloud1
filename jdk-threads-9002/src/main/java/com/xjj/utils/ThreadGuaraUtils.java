package com.xjj.utils;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 推荐采用goole的guava包(推荐)
 */
public class ThreadGuaraUtils {


    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build();

    private static ExecutorService executor =new ThreadPoolExecutor(5, 200,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024),//固定队列最大容量
            namedThreadFactory,//采用guava提供的线程工厂,之前默认提供的是默认线程工厂，实质上是一个ThreadGroup
            new ThreadPoolExecutor.AbortPolicy());//拒绝策略设置：抛出异常;

    public static ExecutorService getThreadExecutor(){
        return executor;
    }


    public static void main(String[] args) {

//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
////            pool.execute(new SubThread());
//        }
        ExecutorService executorService = ThreadGuaraUtils.getThreadExecutor();
    }
}
