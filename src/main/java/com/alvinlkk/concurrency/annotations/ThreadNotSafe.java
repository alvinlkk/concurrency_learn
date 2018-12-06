package com.alvinlkk.concurrency.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 课程中标记【线程不安全】的类或者写法
 *
 * @author alvinkk
 * @create 2018-12-06 19:44
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadNotSafe {

    String value() default "";
}
