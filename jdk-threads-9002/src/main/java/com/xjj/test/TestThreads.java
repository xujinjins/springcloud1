package com.xjj.test;

import com.xjj.utils.ThreadUtils;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 对线程池进行测试
 */
public class TestThreads {

    private static ExecutorService executor =null;
/**
     *    固定线程池
     */
    @Test
    public void testFixedThreadPool() {
        executor = new ThreadUtils().getFixedThreadPool(5);
        People people = new People();
        for (int i =0;i<5;i++){
            executor.execute(people);
        }
        executor.shutdown();
    }
    /**
     * 调度线程池，用的不太顺手，待定
     */
    @Test
    public void testScheduledThreadPool() {
        ScheduledExecutorService  executor1 = new ThreadUtils().getScheduledThreadPool(2);
        People people = new People();
//        executor.schedule(people,1000, TimeUnit.MICROSECONDS);一秒后执行
        // 延迟1000ms 每隔1000ms 重复执行 任务
//        executor1.scheduleAtFixedRate(people,1000,1000,TimeUnit.MICROSECONDS);
//        for (int i =0;i<5;i++) {
            executor1.scheduleWithFixedDelay(people, 1000, 1000, TimeUnit.MICROSECONDS);
//        }
//        executor.shutdown();
    }

    /**
     * 单线程池
     * 这个无需加锁，毕竟单线程
     */
    @Test
    public void testSingleThreadPool() {
        executor = new ThreadUtils().getSingleThreadPool();
        People people = new People();
        for (int i =0;i<5;i++){
            executor.execute(people);
        }
        executor.shutdown();
    }

    /**
     * 缓存线程池
     */
    @Test
    public void testCachedThreadPool() {
        executor = new ThreadUtils().getCachedThreadPool();
        People people = new People();
        for (int i =0;i<5;i++){
            executor.execute(people);
        }
        executor.shutdown();
    }
}
class People implements Runnable{

    private static int i =0;

    @Override
    public  void run() {
        i++;
        System.out.println(i);
    }
}