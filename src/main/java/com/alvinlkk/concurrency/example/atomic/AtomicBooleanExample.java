package com.alvinlkk.concurrency.example.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * atomicBoolean 例子
 * @author alvinkk
 * @create 2018-12-07 10:13
 **/
@Slf4j
public class AtomicBooleanExample {

    private static final int THREAD_NUM = 100;

    private static AtomicBoolean atBoolean = new AtomicBoolean(false);

    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<THREAD_NUM; i++) {
            executorService.execute(() -> {
                if(atBoolean.compareAndSet(false, true)) {
                    log.info("go into threadpool");
                }
                countDownLatch.countDown();
            });

        }
        countDownLatch.await();
        log.info("done!");

        //关闭线程池
        executorService.shutdown();
    }
}
