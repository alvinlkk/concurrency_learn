package com.alvinlkk.concurrency.example.singleton;

import com.alvinlkk.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式  单例在类加载的时候创建   新写法
 *
 * 如果单例创建的逻辑复杂，花费时间长，不适合这种方式
 *
 */
@ThreadSafe
public class SingletonExample6 {

    //私有构造函数
    private SingletonExample6() {};

    //单例对象
    private static SingletonExample6 instance = null;

    // 静态域需在前面
    static {
        instance = new SingletonExample6();
    }

    //静态工厂方法
    public static SingletonExample6 getInstance() {
        return instance;
    }

}
