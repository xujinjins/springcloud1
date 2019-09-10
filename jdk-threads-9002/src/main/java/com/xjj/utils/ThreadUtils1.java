package com.xjj.utils;

import java.util.concurrent.*;

/**
 * 获取线程池(仅供参考)
 * 放弃线程池提供的现成方法，根据实际情况，使用其构造自行创建
 * 已废弃，仅供参考。可取最优的guava策略。
 */
@Deprecated
public class ThreadUtils1 {

    public ExecutorService executor;

    /**
     * 获取固定大小线程池
     * 采用ArrayBlockingQueue有界队列来代替
     */
    public ExecutorService getFixedThreadPool(int threadSize) {
        executor = new ThreadPoolExecutor(threadSize, threadSize,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue(threadSize));//实际这个量感觉并不合适，除非严格要求。
        return executor;
    }

//    /**
//     *     创建缓存线程池
//     *     创建一个可缓存的线程池，调用execute 将重用以前构造的线程（如果线程可用）。
//     *     如果没有可用的线程，则创建一个新线程并添加到池中。终止并从缓存中移除那些
//     *     已有 60 秒钟未被使用的线程。
//     */
//    public ExecutorService getCachedThreadPool() {
//        executor = Executors.newCachedThreadPool();
//        return executor;
//    }
//
//    /**
//     * 创建单线程池
//     */
//    public ExecutorService getSingleThreadPool() {
//        executor = Executors.newSingleThreadExecutor();
//        return executor;
//    }
//
//    /**
//     * 创建支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类
//     * 看起来功能还是比较强大的，又用到了工厂模式、又有比较强的扩展性，重要的是用起来还比较方便
//     */
//    public ExecutorService getScheduledThreadPool(int threadSize) {
//        executor = Executors.newScheduledThreadPool(threadSize);
//        return executor;
//    }

}
