package com.xjj.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 获取线程池工具类(不推荐)
 * ThreadPool中使用LinkedBlockingQueue并未指定大小，默认为无界队列，
 * 最大长度为Integer.MAX_VALUE
 * 一旦无限添加任务，会造成oom内存溢出
 * 例： for (int i = 0; i < Integer.MAX_VALUE; i++) {
 *             executor.execute(new SubThread());
 *         }
 */
public class ThreadUtils {

    public  ExecutorService executor;

    /**
     * 获取固定大小线程池
     */
    public ExecutorService getFixedThreadPool(int threadSize) {
        executor = Executors.newFixedThreadPool(threadSize);
        return executor;
    }

    /**
     *     创建缓存线程池
     *     创建一个可缓存的线程池，调用execute 将重用以前构造的线程（如果线程可用）。
     *     如果没有可用的线程，则创建一个新线程并添加到池中。终止并从缓存中移除那些
     *     已有 60 秒钟未被使用的线程。
     */
    public ExecutorService getCachedThreadPool() {
        executor = Executors.newCachedThreadPool();
        return executor;
    }

    /**
     * 创建单线程池
     */
    public ExecutorService getSingleThreadPool() {
        executor = Executors.newSingleThreadExecutor();
        return executor;
    }

    /**
     * 创建支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类
     * 看起来功能还是比较强大的，又用到了工厂模式、又有比较强的扩展性，重要的是用起来还比较方便
     */
    public ScheduledExecutorService getScheduledThreadPool(int threadSize) {

        return Executors.newScheduledThreadPool(threadSize);
    }
}
