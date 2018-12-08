package com.alvinlkk.concurrency.example.singleton;

import com.alvinlkk.concurrency.annotations.NotRecommend;
import com.alvinlkk.concurrency.annotations.ThreadNotSafe;
import com.alvinlkk.concurrency.annotations.ThreadSafe;

//懒汉模式： 单例实例在第一次使用的时候初始化
@ThreadNotSafe
@NotRecommend
public class SingletonExample4 {

    //私有构造函数
    private SingletonExample4() {};

    //单例对象
    private static SingletonExample4 instance = null;

    //静态工厂方法
    public synchronized static SingletonExample4 getInstance() {
        if(instance == null) {   //双重检测机制
            synchronized (SingletonExample4.class) {
                if(instance == null) {

                    //1. 分配对象内存空间   2. 初始化对象    3. 设置instance 指向刚分配的内存
                    // jvm和cpu优化发生指令重排  可能第3步在第2步之前。 所以有可能第二个线程获取的单例还没有初始化导致使用它时存在问题
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }

}
