package com.alvinlkk.concurrency.example.singleton;

import com.alvinlkk.concurrency.annotations.Recommend;
import com.alvinlkk.concurrency.annotations.ThreadSafe;

//枚举单例模式  最安全
@ThreadSafe
@Recommend
public class SingletonExample7 {

    private SingletonExample7() {}

    public static SingletonExample7 getInstance() {
        return Singleton.SINGTON.getSingletonExample7();
    }

    private enum Singleton {
        SINGTON;

        private SingletonExample7 singletonExample7;

        //jvm保证只执行一次
        private Singleton() {
            singletonExample7 = new SingletonExample7();
        }

        public SingletonExample7 getSingletonExample7() {
            return this.singletonExample7;
        }
    }

}
