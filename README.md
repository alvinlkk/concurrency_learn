### 线程以及并发学习实践

#### 线程中断
- void interrupt(): 中断线程,也就是将中断位设置为true。 如果执行该方法时，线程处于sleep、wait、可阻断的io等阻塞时，会中断线程状态，抛出InterrputedException,同时，线程的中断位会设置为false。 如果线程是处于synchronize获取锁阻塞时，不会响应。
- boolean isInterrupted() : 返回线程是否中断，如果中断，返回true, 否则返回false。
- static boolean interrupted()： 返回线程是否中断，同时会将当前线程的中断标志位设置为false。
