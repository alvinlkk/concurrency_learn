package com.alvinlkk.concurrency.example.singleton;

import com.alvinlkk.concurrency.annotations.NotRecommend;
import com.alvinlkk.concurrency.annotations.ThreadNotSafe;
import com.alvinlkk.concurrency.annotations.ThreadSafe;

//懒汉模式： 单例实例在第一次使用的时候初始化
// 影响性能
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    //私有构造函数
    private SingletonExample3() {};

    //单例对象
    private static SingletonExample3 instance = null;

    //静态工厂方法
    public synchronized static SingletonExample3 getInstance() {
        if(instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }

}
