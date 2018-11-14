package com.alvinlkk.concurrency.interrupt;

/**
 * 线程中断测试
 *
 * @author alvinkk
 * @create 2018-11-14 20:30
 **/
public class InpterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                //interruppted()是线程类的静态方法，返回线程的中断标志，同时，会将线程的中断标志设置为false,再次执行时，就返回false
                while (!interrupted()) {
                    System.out.println(this.isInterrupted());
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        // 捕获异常后会清空中断标志，设为false
                        System.out.println("线程结束, 中断标志: " + this.isInterrupted());
                    }
                }
                System.out.println("线程结束, 中断标志: " + this.isInterrupted());
            }
        };

        thread.start();
        Thread.sleep(10);
        //对线程进行中断, interrupt 会对线程中处于sleep、wait、可中断的I/O处的地方做出响应，抛出InterruptedException异常，但是对于synchronized的阻塞不会中断
        thread.interrupt();
    }
}
