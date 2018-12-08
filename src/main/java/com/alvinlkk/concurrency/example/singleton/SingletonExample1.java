package com.alvinlkk.concurrency.example.singleton;

import com.alvinlkk.concurrency.annotations.ThreadNotSafe;

//懒汉模式： 单例实例在第一次使用的时候初始化
@ThreadNotSafe
public class SingletonExample1 {

    //私有构造函数
    private SingletonExample1() {};

    //单例对象
    private static SingletonExample1 instance = null;

    //静态工厂方法
    public static SingletonExample1 getInstance() {
        if(instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }

}
