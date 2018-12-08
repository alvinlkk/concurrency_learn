package com.alvinlkk.concurrency.example.singleton;

import com.alvinlkk.concurrency.annotations.ThreadNotSafe;
import com.alvinlkk.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式  单例在类加载的时候创建
 *
 * 如果单例创建的逻辑复杂，花费时间长，不适合这种方式
 *
 */
@ThreadSafe
public class SingletonExample2 {

    //私有构造函数
    private SingletonExample2() {};

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }

}
