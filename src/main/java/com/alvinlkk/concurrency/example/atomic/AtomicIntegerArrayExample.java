package com.alvinlkk.concurrency.example.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * atomicIntegerArrayoolean 例子
 * @author alvinkk
 * @create 2018-12-07 10:13
 **/
@Slf4j
public class AtomicIntegerArrayExample {

    private static final int THREAD_NUM = 100;

    private static AtomicIntegerArray integerArray = new AtomicIntegerArray(10);

    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<THREAD_NUM; i++) {
            executorService.execute(() -> {
                atomicOper();
                countDownLatch.countDown();
            });

        }
        countDownLatch.await();
        log.info("value: {}", integerArray.get(0));
        log.info("done!");

        //关闭线程池
        executorService.shutdown();
    }

    public static void atomicOper() {
        integerArray.compareAndSet(0, 0, 10);
    }
}
